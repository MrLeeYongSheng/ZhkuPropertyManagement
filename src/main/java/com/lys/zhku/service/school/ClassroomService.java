package com.lys.zhku.service.school;

import com.lys.zhku.model.Classroom;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;

public interface ClassroomService {

	/**
	 * 根据分页参数获取分页记录
	 * @param pagination
	 * @return
	 */
	Page<Classroom> getPageByPagination(Pagination pagination);

	/**
	 * 插入宿舍记录
	 * @param classroom
	 * @return
	 */
	int insertClassroom(Classroom classroom);

	/**
	 * 根据传进来的数组id删除对应记录
	 * @param ids
	 * @return
	 */
	int deleteClassrooms(Integer[] ids);

	/**
	 * 根据主键修改记录
	 * @param classroom
	 * @return
	 */
	int updateClassroom(Classroom classroom);

}
