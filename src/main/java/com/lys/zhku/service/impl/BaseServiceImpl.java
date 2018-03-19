package com.lys.zhku.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.lys.zhku.mapper.base.BaseMapper;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.BaseService;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.StatusCode;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	protected BaseMapper<T> baseMapper;
	
	@SuppressWarnings("rawtypes")
	@PostConstruct
	private void initBaseMapper() throws Exception {
		Field baseMapperField = this.getClass().getSuperclass().getDeclaredField("baseMapper");
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class type = (Class) parameterizedType.getActualTypeArguments()[0];
		String simpleName = type.getSimpleName();
		String targetFieldName = simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1)+"Mapper";
		Field targetField = this.getClass().getDeclaredField(targetFieldName);
		targetField.setAccessible(true);//使非公有字段可以进行操作
		baseMapperField.set(this, targetField.get(this));
	}

	@Override
	public Page<T> getPageByPagination(Pagination pagination) {
		Page<T> page = new Page<>();
		int count = baseMapper.selectCountByPagination(pagination);
		page.setTotal(count);
		if(count<1) {
			page.setRows(new ArrayList<>());
			return page;
		}
		List<T> list = baseMapper.selectByPagination(pagination);
		page.setRows(list);
		return page;
	}

	@Override
	public int deleteEntitys(Integer[] ids) {
		if(CollectionUtils.isEmpty(ids)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return baseMapper.deleteByPrimaryKeys(ids);
	}

	@Override
	public int insertEntity(T record) {
		//数据的合法性由controller来校验
		if(existEntity(record)>0) {
			throw new ErrorException(StatusCode.EXIST, "记录已经存在,插入失败");
		}
		return baseMapper.insert(record);
	}

	@Override
	public int updateEntity(T record) {
		//数据的合法性由controller来校验
		return baseMapper.updateByPrimaryKey(record);
	}

}
