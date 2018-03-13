package com.lys.zhku.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.zhku.mapper.DatadictMapper;
import com.lys.zhku.model.Datadict;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.system.DatadictService;
import com.lys.zhku.utils.ModelUtils;
import com.lys.zhku.utils.StatusCode;

@Service
public class DatadictServiceImpl implements DatadictService{
	
	@Autowired
	private DatadictMapper datadictMapper; 
	
	@Override
	public List<Datadict> getDataDictList(String key) {
		List<Datadict> list = new ArrayList<>();
		Datadict dd1 = new Datadict(1,"campus","海珠",null,true);
		Datadict dd2 = new Datadict(2,"campus","白云",null,true);
		list.add(dd1);
		list.add(dd2);
		return list;
	}

	@Override
	public List<Datadict> getDataDictListByParentId(Integer parentId) {
		List<Datadict> list = new ArrayList<>();
		Datadict dd1 = new Datadict(3,"department","信科院",null,true);
		Datadict dd2 = new Datadict(4,"department","自动化院",null,true);
		list.add(dd1);
		list.add(dd2);
		return list;
	}

	@Override
	public int insertDatadict(Datadict datadict) {
		if(datadict==null || !ModelUtils.isNotNullForAllNotNullFieldExceptPrimaryKey(datadict)) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "缺失请求参数");
		}
		return datadictMapper.insert(datadict);
	}

	@Override
	public Page<Datadict> getDatadictPage(Pagination pagination) {
		Page<Datadict> page = new Page<>();
		int total = datadictMapper.selectCountByEnable(pagination);
		page.setTotal(total);
		if(total==0) {
			page.setRows(new ArrayList<>());
			return page;
		}
		List<Datadict> rows = datadictMapper.selectByPagination(pagination);
		page.setRows(rows);
		return page;
	}

	@Override
	public int deleteDatadictByIds(Integer[] ids) {
		if(ids==null || ids.length==0) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return datadictMapper.deleteByPrimaryKeys(ids);
	}

	@Override
	public int editDatadictByIds(Datadict datadict) {
		if(datadict==null || !ModelUtils.isNotNullForAllNotNullField(datadict)) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "缺失必要字段");
		}
		return datadictMapper.updateByPrimaryKey(datadict);
	}

	@Override
	public List<Datadict> getListByDatadict(Datadict datadict) {
		if(datadict==null) {
			System.out.println("参数:Datadict对象为null: "+getClass()+ "#getListByDatadict");
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "内部错误");
		}
		return datadictMapper.getListByDatadict(datadict);
	}
}
