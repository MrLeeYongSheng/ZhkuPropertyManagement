package com.lys.zhku.service.files;

import java.util.List;

import javax.servlet.http.Part;

import com.lys.zhku.model.Files;
import com.lys.zhku.service.BaseService;

public interface FilesService<T> extends BaseService<T>{

	int insertFiles(List<Files> filesList);

	List<String> selectUuidNameByPrimaryKeys(Integer[] ids);



}
