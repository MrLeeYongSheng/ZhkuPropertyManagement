package com.lys.zhku.service.files;

import java.util.List;

import com.lys.zhku.model.PersonalFiles;
import com.lys.zhku.service.BaseService;

public interface PersonalFilesService extends BaseService<PersonalFiles>{

	/**
	 * 批量插入
	 * @param filesList
	 * @return
	 */
	int insertFiles(List<PersonalFiles> filesList);

	/**
	 * 根据ids获取Files
	 * @param ids
	 * @return
	 */
	List<PersonalFiles> selectByPrimaryKeys(Integer[] ids);

	/**
	 * 根据ids获取UUIDName和Position
	 * @param ids
	 * @return
	 */
	List<? super PersonalFiles> selectUuidNameAndPositionByPrimaryKeys(Integer[] ids);

	/**
	 * 根据id获取Files
	 * @param id
	 * @return
	 */
	PersonalFiles selectByPrimaryKey(Integer id);

	/**
	 * 根据usersUsername获取记录
	 * @param username
	 * @return
	 */
	List<PersonalFiles> selectPositionByUsersUsername(String usersUsername);

}
