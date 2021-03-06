package com.lys.zhku.service.school;

import com.lys.zhku.model.Dormitory;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.BaseService;

public interface DormitoryService extends BaseService<Dormitory>{

	Page<Dormitory> getPageByPagination(Pagination pagination);

	/**
	 * 插入宿舍记录
	 * @param dormitory
	 * @return
	 */
	int insertDormitory(Dormitory dormitory);

	/**
	 * 根据传进来的数组id删除对应记录
	 * @param ids
	 * @return
	 */
	int deleteDormitorys(Integer[] ids);

	/**
	 * 根据主键修改记录
	 * @param dormitory
	 * @return
	 */
	int updateDormitory(Dormitory dormitory);

	/**
	 * 根据Students表的userUsername获取记录
	 * @param usersUsername
	 * @return
	 */
	Dormitory getFromStudentsByUserUsername(String usersUsername);

}
