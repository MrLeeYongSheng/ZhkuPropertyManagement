package com.lys.zhku.service.students;

import com.lys.zhku.model.Students;
import com.lys.zhku.model.Userdetails;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;

public interface StudentsService {

	/**
	 * 插入一条学生记录,并创建默认账号
	 * @param student
	 * @param userdetail
	 * @return
	 */
	Integer insertStudent(Students student, Userdetails userdetail);
	
	/**
	 * 获取学生的Students表的数据分页记录
	 * @param pagination
	 * @return
	 */
	Page<Students> getStudentsPage(Pagination pagination);
}
