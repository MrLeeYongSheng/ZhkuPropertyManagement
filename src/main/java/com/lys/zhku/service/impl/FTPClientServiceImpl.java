package com.lys.zhku.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lys.zhku.model.Files;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.service.FTPClientService;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.FileUtils;
import com.lys.zhku.utils.StatusCode;
import com.lys.zhku.utils.StringUtils;

/**
 * @author MrLeeYongSheng
 *
 */
@Service
public class FTPClientServiceImpl implements FTPClientService {

	@Autowired
	private Environment env;

	private static Logger log = Logger.getLogger(FTPClientServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lys.zhku.service.impl.FTPClientService#uploadFileToFtpServer(javax.
	 * servlet.http.Part[], java.lang.String)
	 */
	@Override
	public List<Files> uploadFileToFtpServer(Part[] files, String parentDir) {

		FTPClient client = connect();
		if (createOrEntryDirs(client, parentDir) < 0) {
			log.error("创建/进入文件夹时发生错误:" + parentDir);
			close(client);
			throw new ErrorException(StatusCode.ERROR, "创建/进入文件夹时发生错误,请检查路径:" + parentDir);
		}
		List<Files> filesList = new ArrayList<>(files.length);
		for (Part part : files) {
			Files fileModel = new Files();
			String uuidName = generateUUIDFileName(part.getSubmittedFileName());
			try {
				InputStream is = part.getInputStream();
				client.storeFile(uuidName, is);
				is.close();
			} catch (IOException e) {
				log.error("使用client.storeFile(uuidName, is)上传文件发送未知错误!", e);
				close(client);
				throw new ErrorException(StatusCode.ERROR, "上传文件时发生未知错误!");
			}
			fileModel.setEnable(true);
			fileModel.setName(part.getSubmittedFileName());
			fileModel.setParentDir(parentDir);
			fileModel.setSize(part.getSize());
			fileModel.setTime(new Date());
			fileModel.setUuidName(uuidName);
			fileModel.setPosition(parentDir);
			filesList.add(fileModel);
		}
		close(client);
		return filesList;
	}

	/**
	 * 获取默认的连接
	 * 
	 * @return
	 */
	private FTPClient connect() {
		FTPClient client = new FTPClient();
		client.setAutodetectUTF8(true);
		client.setCharset(Charset.forName(env.getProperty("encoding")));
		client.setBufferSize(1024);
		client.setControlEncoding(env.getProperty("encoding"));
		client.enterLocalPassiveMode();// 进入本地被动模式,防止本地端口被占用
		String ftpUrl = env.getProperty("ftp.url");
		String ftpUser = env.getProperty("ftp.username");
		String ftpPasswd = env.getProperty("ftp.password");
		try {
			client.connect(ftpUrl);
		} catch (IOException e) {
			log.error("ftp.url 连接失败:" + ftpUrl + "\t--ftp 服务器开启了?", e);
			close(client);
			throw new ErrorException(StatusCode.ERROR, "连接ftp服务器失败");
		}
		try {
			client.login(ftpUser, ftpPasswd);
		} catch (IOException e) {
			log.error("登录失败,账号:" + ftpUser + " 密码:" + ftpPasswd, e);
			close(client);
			throw new ErrorException(StatusCode.ERROR, "登录ftp服务器失败");
		}
		try {
			client.setFileType(FTP.BINARY_FILE_TYPE);
		} catch (IOException e) {
			log.error("设置文件类型错误:" + FTP.BINARY_FILE_TYPE, e);
			close(client);
			throw new ErrorException(StatusCode.ERROR, "服务器内部错误!");
		}
		return client;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lys.zhku.service.impl.FTPClientService#generateUUIDFileName(java.lang.
	 * String)
	 */
	@Override
	public String generateUUIDFileName(String orginName) {
		return UUID.randomUUID().toString().replaceAll("-", "") + "-" + orginName;
	}

	/**
	 * 创建文件夹并进入文件夹,若所有文件夹已存在则进入文件夹
	 * 
	 * @param path
	 *            绝对路径
	 * @return -1:创建失败, 0:已经存在, 1:创建成功
	 */
	private int createOrEntryDirs(FTPClient client, String path) {
		String filePath = FileUtils.trans2SysSeparator(path);
		String[] array = FileUtils.splitSysSeparator2Array(filePath);
		try {
			client.changeWorkingDirectory("/");
		} catch (IOException e) {
			log.error("进入根目录失败", e);
			close(client);
			return -1;
		}
		if ("".equals(array[0]))
			return 0;
		for (String subPath : array) {
			try {
				if (!client.changeWorkingDirectory(subPath)) {// 目录不存在
					client.mkd(subPath);// 创建目录
					client.changeWorkingDirectory(subPath);// 进入目录
				} else {
					client.changeWorkingDirectory(subPath);// 进入目录
				}
			} catch (IOException e) {
				log.error("创建/进入文件夹失败:" + subPath, e);
				close(client);
				return -1;
			}
		}
		return 1;
	}

	private void close(FTPClient client) {
		try {
			client.logout();
			client.disconnect();
		} catch (IOException e) {
			log.error("关闭ftp服务器连接错误", e);
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lys.zhku.service.FTPClientService#deleteByFiles(java.util.List)
	 */
	@Override
	public int deleteByFiles(List<Files> filesList) {
		if (CollectionUtils.isEmpty(filesList)) {
			log.error("数据丢失:List<Files>:" + filesList);
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "操作失败,数据丢失");
		}
		FTPClient client = connect();
		try {
			client.changeWorkingDirectory("/");
		} catch (IOException e) {
			log.error("进入根目录失败", e);
			close(client);
			throw new ErrorException(StatusCode.ERROR, "操作失败,ftp服务器连接错误");
		}
		for (Files file : filesList) {
			try {
				// 使用File为了拼接文件路径
				String path = new File(file.getPosition(), file.getUuidName()).getPath();
				path = path.replace("\\", "/");
				int deleFlag = client.dele(path);
				if (deleFlag != 250) {
					path = path.replace("/", "\\");
					client.dele(path);

				}
			} catch (IOException e) {
				log.error("ftp服务器删除文件异常,请检查连接状况:" + file.getPosition() + ":" + file.getName(), e);
			}
		}
		return 1;
	}

	@Override
	public int downloadFilesToResponse(Files file, HttpServletResponse response) {
		if (file == null) {
			log.error("files为null,没有东西可提供下载");
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数,没有文件可提供下载");
		}
		FTPClient ftpClient = connect();
		// response操作
		response.setCharacterEncoding("UTF-8");
		response.setContentType("multipart/form-data;charset=UTF-8");
		try {
			response.setHeader("Content-Disposition", "attachment;fileName="
					+ new String(file.getName().getBytes(env.getProperty("encoding", "UTF-8")), "ISO8859-1"));
			// 建立传输通道
			OutputStream os = response.getOutputStream();
			// ftp获取文件,将文件传输到os通道
			String path = new File(file.getPosition(), file.getUuidName()).getPath();
			path = path.replace("\\", "/");
			if(!ftpClient.retrieveFile(path, os)) {
				//删除失败,有可能是因为路径分隔符所造成的
				path = path.replace("/", "\\");
				if(!ftpClient.retrieveFile(path, os)) {
					log.error("下载失败,请查看文件路径:"+path+" 是否正确?或者查看文件是否存在");
					throw new ErrorException(StatusCode.ERROR, "下载文件失败");
				}
			}
			// 清空os缓存
			os.flush();
			// 关闭os
			os.close();
			// 清空response缓存,提交response,将内容完全写到客户端浏览器
			response.flushBuffer();
			// end 传输数据
			// end response操作
		} catch (Exception e) {
			e.printStackTrace();
		}
		//关闭ftp连接
		close(ftpClient);
		return 1;// 返回一个积极地数字
	}

}
