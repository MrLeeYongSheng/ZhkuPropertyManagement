package com.lys.zhku.service.students;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

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
	 * 更新一条学生记录
	 * @param student
	 * @param userdetail
	 * @return
	 */
	Integer updateStudent(Students student, Userdetails userdetail);
	
	/**
	 * 获取学生的Students表的数据分页记录
	 * @param pagination
	 * @return
	 */
	Page<Students> getStudentsPage(Pagination pagination);
	
	/**
	 * 物理删除:根据usersUsernames数组删除对应的记录
	 * @param usersUsernames
	 * @return
	 */
	Integer deleteStudentsByUsersUsernames(String[] usersUsernames);

	/**
	 * 获取所有信息
	 * @return
	 */
	List<Students> getAll();

	/**
	 * 根据主键数组获取对应记录
	 * @param pks
	 * @return
	 */
	List<Students> getByPrimaryKeys(String[] pks);

	/**
	 * 根据usersUsername获取记录
	 * @param usersUsername
	 * @return
	 */
	Students getByPrimaryKey(String usersUsername);

}
