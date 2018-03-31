package com.lys.zhku.service.school;

import com.lys.zhku.model.ClassroomSchedule;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.BaseService;

public interface ClassroomScheduleService extends BaseService<ClassroomSchedule>{

	/**
	 * 根据分页参数获取分页记录
	 * @param pagination
	 * @return
	 */
	Page<ClassroomSchedule> getPageByPagination(Pagination pagination);

	/**
	 * 插入宿舍记录
	 * @param classroom
	 * @return
	 */
	int insertClassroomSchedule(ClassroomSchedule classroomSchedule);

	/**
	 * 根据传进来的数组id删除对应记录
	 * @param ids
	 * @return
	 */
	int deleteClassroomSchedule(Integer[] ids);

	/**
	 * 根据主键修改记录
	 * @param classroom
	 * @return
	 */
	int updateClassroomSchedule(ClassroomSchedule classroomSchedule);

}
