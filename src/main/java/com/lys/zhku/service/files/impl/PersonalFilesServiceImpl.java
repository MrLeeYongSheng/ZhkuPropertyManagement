package com.lys.zhku.service.files.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.zhku.mapper.PersonalFilesMapper;
import com.lys.zhku.model.PersonalFiles;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.query.FileQuery;
import com.lys.zhku.service.files.PersonalFilesService;
import com.lys.zhku.service.impl.BaseServiceImpl;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.StatusCode;
import com.lys.zhku.utils.StringUtils;

@Service
public class PersonalFilesServiceImpl extends BaseServiceImpl<PersonalFiles> implements PersonalFilesService {

	@Autowired
	private PersonalFilesMapper personalFilesMapper;

	
	private static Logger log = Logger.getLogger(PersonalFilesServiceImpl.class);

	@Override
	public int existEntity(PersonalFiles record) {
		return 0;
	}

	@Override
	public int insertFiles(List<PersonalFiles> filesList) {
		if(CollectionUtils.isEmpty(filesList)) {
			log.error(this.getClass()+"#insertFiles的list参数为空");
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return personalFilesMapper.insertFiles(filesList);
	}

	@Override
	public List<PersonalFiles> selectByPrimaryKeys(Integer[] ids) {
		if(CollectionUtils.isEmpty(ids)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return personalFilesMapper.selectByPrimaryKeys(ids);
	}

	@Override
	public List<? super PersonalFiles> selectUuidNameAndPositionByPrimaryKeys(Integer[] ids) {
		if(CollectionUtils.isEmpty(ids)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return personalFilesMapper.selectUuidNameAndPositionByPrimaryKeys(ids);
	}

	@Override
	public PersonalFiles selectByPrimaryKey(Integer id) {
		if(id==null) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return personalFilesMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PersonalFiles> selectPositionByUsersUsername(String usersUsername) {
		if(StringUtils.isEmpty(usersUsername)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return personalFilesMapper.selectPositionByUsersUsername(usersUsername);
	}

	@Override
	public List<PersonalFiles> selectPositionByFileQuery(FileQuery fileQuery) {
		if(fileQuery == null) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return personalFilesMapper.selectPositionByFileQuery(fileQuery);
	}

}
