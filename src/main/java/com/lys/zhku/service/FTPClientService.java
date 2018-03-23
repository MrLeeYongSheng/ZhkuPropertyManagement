package com.lys.zhku.service;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.lys.zhku.model.Files;

public interface FTPClientService {

	/**
	 * 上传文件<br>
	 * @param files 允许上传具有相同名字的,服务器所存储的为uuid名字
	 * @param parentDir 允许为null或""或"/",若为空则存储在根目录
	 * @return 返回成功上传的文件信息列表
	 */
	List<Files> uploadFileToFtpServer(Part[] files, String parentDir);

	/**
	 * 生成uuidfileName
	 * @param orginName
	 * @return
	 */
	String generateUUIDFileName(String orginName);

	/**
	 * 根据Files的position和UUIDName来定位文件并删除
	 * @param filesList
	 * @return 1:成功
	 */
	int deleteByFiles(List<Files> filesList);

	/**
	 * 根据Files来向ftp下载文件,并在OutputStream输出
	 * @param file
	 * @param response
	 * @return
	 */
	int downloadFilesToResponse(Files file, HttpServletResponse response);

}