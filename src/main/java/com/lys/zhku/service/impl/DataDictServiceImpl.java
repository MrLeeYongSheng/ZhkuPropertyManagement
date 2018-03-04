package com.lys.zhku.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.zhku.mapper.UsersMapper;
import com.lys.zhku.model.Users;
import com.lys.zhku.model.dictionary.DataDict;
import com.lys.zhku.service.DataDictService;

@Service("dataDictServiceImpl")
public class DataDictServiceImpl implements DataDictService{
	
	@Autowired
	private UsersMapper usersMapper;

	/* (non-Javadoc)
	 * @see com.lys.zhku.service.DataDictServiceInter#getDataDictList(java.lang.String)
	 */
	@Override
	public List<DataDict> getDataDictList(String key) {
		List<DataDict> list = new ArrayList<>();
		DataDict dd1 = new DataDict(1,"campus","海珠",null,true);
		DataDict dd2 = new DataDict(2,"campus","白云",null,true);
		list.add(dd1);
		list.add(dd2);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.lys.zhku.service.DataDictServiceInter#getDataDictListByParentId(java.lang.Integer)
	 */
	@Override
	public List<DataDict> getDataDictListByParentId(Integer parentId) {
		List<DataDict> list = new ArrayList<>();
		DataDict dd1 = new DataDict(3,"department","信科院",null,true);
		DataDict dd2 = new DataDict(4,"department","自动化院",null,true);
		list.add(dd1);
		list.add(dd2);
		return list;
	}
}
