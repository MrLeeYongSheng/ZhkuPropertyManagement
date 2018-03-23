package com.lys.zhku.service.files;

import java.util.List;

import javax.servlet.http.Part;

import com.lys.zhku.model.Files;
import com.lys.zhku.service.BaseService;

public interface FilesService<T> extends BaseService<T>{

	/**
	 * 批量插入
	 * @param filesList
	 * @return
	 */
	int insertFiles(List<Files> filesList);

	/**
	 * 根据ids获取Files
	 * @param ids
	 * @return
	 */
	List<Files> selectByPrimaryKeys(Integer[] ids);

	/**
	 * 根据ids获取UUIDName和Position
	 * @param ids
	 * @return
	 */
	List<Files> selectUuidNameAndPositionByPrimaryKeys(Integer[] ids);

	/**
	 * 根据id获取Files
	 * @param id
	 * @return
	 */
	Files selectByPrimaryKey(Integer id);

}
