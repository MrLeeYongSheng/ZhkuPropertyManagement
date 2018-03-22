package com.lys.zhku.service.files.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lys.zhku.mapper.FilesMapper;
import com.lys.zhku.model.Files;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.service.files.FilesService;
import com.lys.zhku.service.impl.BaseServiceImpl;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.StatusCode;

@Service
public class FilesServiceImpl extends BaseServiceImpl<Files> implements FilesService<Files> {

	@Autowired
	private FilesMapper filesMapper;

	
	private static Logger log = Logger.getLogger(FilesServiceImpl.class);

	@Override
	public int existEntity(Files record) {
		return 0;
	}

	@Override
	public int insertFiles(List<Files> filesList) {
		if(CollectionUtils.isEmpty(filesList)) {
			log.error(this.getClass()+"#insertFiles的list参数为空");
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return filesMapper.insertFiles(filesList);
	}

	@Override
	public List<String> selectUuidNameByPrimaryKeys(Integer[] ids) {
		if(CollectionUtils.isEmpty(ids)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return filesMapper.selectUuidNameByPrimaryKeys(ids);
	}

}
