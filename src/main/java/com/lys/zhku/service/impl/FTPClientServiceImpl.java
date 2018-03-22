package com.lys.zhku.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

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
	 * @see com.lys.zhku.service.impl.FTPClientService#uploadFileToFtpServer(javax.servlet.http.Part[], java.lang.String)
	 */
	@Override
	public List<Files> uploadFileToFtpServer(Part[] files, String parentDir) {

		Map<String,String> nameMap = new HashMap<>(files.length);
		FTPClient client = new FTPClient();
		client.setAutodetectUTF8(true);
		client.setCharset(Charset.forName(env.getProperty("encoding")));
		client.setBufferSize(1024);
		client.setControlEncoding(env.getProperty("encoding"));
		client.enterLocalPassiveMode();//进入本地被动模式,防止本地端口被占用
		String ftpUrl = env.getProperty("ftp.url");
		String ftpUser = env.getProperty("ftp.username");
		String ftpPasswd = env.getProperty("ftp.password");
		try {
			client.connect(ftpUrl);
		} catch (IOException e) {
			log.error("ftp.url 连接失败:"+ftpUrl+"\t--ftp 服务器开启了?", e);
			close(client);
			throw new ErrorException(StatusCode.ERROR, "连接ftp服务器失败");
		}
		try {
			client.login(ftpUser, ftpPasswd);
		} catch (IOException e) {
			log.error("登录失败,账号:"+ftpUser+" 密码:"+ftpPasswd, e);
			close(client);
			throw new ErrorException(StatusCode.ERROR, "登录ftp服务器失败");
		}
		try {
			client.setFileType(FTP.BINARY_FILE_TYPE);
		} catch (IOException e) {
			log.error("设置文件类型错误:"+FTP.BINARY_FILE_TYPE, e);
			close(client);
			throw new ErrorException(StatusCode.ERROR, "服务器内部错误!");
		}
		if(createOrEntryDirs(client, parentDir)<0) {
			log.error("创建/进入文件夹时发生错误:"+parentDir);
			close(client);
			throw new ErrorException(StatusCode.ERROR, "创建/进入文件夹时发生错误,请检查路径:"+parentDir);
		}
		List<Files> filesList = new ArrayList<>(files.length);
		for (Part part : files) {
			Files fileModel = new Files();
			String uuidName = generateUUIDFileName(part.getSubmittedFileName());
			try {
				InputStream is = part.getInputStream();
				client.storeFile(uuidName, is);
				nameMap.put(part.getSubmittedFileName(), uuidName);
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
			filesList.add(fileModel);
		}
		close(client);
		return filesList;
	}
	
	/* (non-Javadoc)
	 * @see com.lys.zhku.service.impl.FTPClientService#generateUUIDFileName(java.lang.String)
	 */
	@Override
	public String generateUUIDFileName(String orginName) {
		return UUID.randomUUID().toString().replaceAll("-", "") + "-" + orginName;
	}
	
	/**
	 * 创建文件夹并进入文件夹,若所有文件夹已存在则进入文件夹
	 * @param path 绝对路径
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
		if("".equals(array[0]))
			return 0;
		for (String subPath : array) {
			try {
				if(!client.changeWorkingDirectory(subPath)) {//目录不存在
					client.mkd(subPath);//创建目录
					client.changeWorkingDirectory(subPath);//进入目录
				} else {
					client.changeWorkingDirectory(subPath);//进入目录
				}
			} catch (IOException e) {
				log.error("创建/进入文件夹失败:"+subPath, e);
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
}
