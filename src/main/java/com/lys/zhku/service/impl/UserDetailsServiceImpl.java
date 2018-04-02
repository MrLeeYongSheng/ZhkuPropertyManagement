package com.lys.zhku.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.zhku.mapper.UserdetailsMapper;
import com.lys.zhku.model.Userdetails;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.service.UserDetailsService;
import com.lys.zhku.utils.ModelUtils;
import com.lys.zhku.utils.StatusCode;
import com.lys.zhku.utils.StringUtils;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserdetailsMapper userdetailsMapper;
	
	@Override
	public Userdetails getUserdetailsByUsersUsername(String usersUsername) {

		if(StringUtils.isEmpty(usersUsername)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		Userdetails userdetail = userdetailsMapper.selectByPrimaryKey(usersUsername);
		if(userdetail==null) {
			throw new ErrorException(StatusCode.NOT_FOUND, "找不到信息记录");
		}
		return userdetail;
	}

	@Override
	public int updateByUsersUsername(Userdetails ud) {
		if(!ModelUtils.isNotNullForAllNotNullField(ud)) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "不完整的参数信息");
		}
		return userdetailsMapper.updateByPrimaryKey(ud);
	}
}
