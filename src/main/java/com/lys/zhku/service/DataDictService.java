package com.lys.zhku.service;

import java.util.List;

import com.lys.zhku.pojo.dictionary.DataDict;

public interface DataDictService {

	List<DataDict> getDataDictList(String key);

	List<DataDict> getDataDictListByParentId(Integer parentId);
}