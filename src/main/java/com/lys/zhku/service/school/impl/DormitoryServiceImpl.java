package com.lys.zhku.service.school.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.zhku.mapper.DormitoryMapper;
import com.lys.zhku.model.Dormitory;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.impl.BaseServiceImpl;
import com.lys.zhku.service.school.DormitoryService;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.ModelUtils;
import com.lys.zhku.utils.StatusCode;
import com.lys.zhku.utils.StringUtils;

@Service
public class DormitoryServiceImpl extends BaseServiceImpl<Dormitory> implements DormitoryService {

	@Autowired
	private DormitoryMapper dormitoryMapper;
	
	@Override
	public Page<Dormitory> getPageByPagination(Pagination pagination) {
		Page<Dormitory> page = new Page<>();
		int count = dormitoryMapper.selectCountByPagination(pagination);
		page.setTotal(count);
		if(count<1) {
			page.setRows(new ArrayList<>());
			return page;
		}
		List<Dormitory> list = dormitoryMapper.selectByPagination(pagination);
		page.setRows(list);
		return page;
	}

	@Override
	public int insertDormitory(Dormitory dormitory) {
		if(dormitory==null || !ModelUtils.isNotNullForAllNotNullFieldExceptPrimaryKey(dormitory)) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "不完整的宿舍信息,缺失必要的请求参数");
		}
		return dormitoryMapper.insert(dormitory);
	}

	@Override
	public int deleteDormitorys(Integer[] ids) {
		if(CollectionUtils.isEmpty(ids)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return dormitoryMapper.deleteByPrimaryKeys(ids);
	}

	@Override
	public int updateDormitory(Dormitory dormitory) {
		if(dormitory==null || !ModelUtils.isNotNullForAllNotNullField(dormitory)) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "不完整的宿舍信息,缺失必要的请求参数");
		}
		return dormitoryMapper.updateByPrimaryKey(dormitory);
	}

	@Override
	public int existEntity(Dormitory record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Dormitory getFromStudentsByUserUsername(String usersUsername) {
		if(StringUtils.isEmpty(usersUsername)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM,"缺失请求参数:usersUsername");
		}
		return dormitoryMapper.selectFromStudentsByUserUsername(usersUsername);
	}

}
