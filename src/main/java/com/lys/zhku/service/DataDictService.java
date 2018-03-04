package com.lys.zhku.service;

import java.util.ArrayList;
import java.util.List;

import com.lys.zhku.model.dictionary.DataDict;

public class DataDictService {

	public List<DataDict> getDataDictList(String key) {
		List<DataDict> list = new ArrayList<>();
		DataDict dd1 = new DataDict(1,"campus","海珠",null,true);
		DataDict dd2 = new DataDict(2,"campus","白云",null,true);
		list.add(dd1);
		list.add(dd2);
		return list;
	}

	public List<DataDict> getDataDictListByParentId(Integer parentId) {
		List<DataDict> list = new ArrayList<>();
		DataDict dd1 = new DataDict(3,"department","信科院",null,true);
		DataDict dd2 = new DataDict(4,"department","自动化院",null,true);
		list.add(dd1);
		list.add(dd2);
		return list;
	}
}
