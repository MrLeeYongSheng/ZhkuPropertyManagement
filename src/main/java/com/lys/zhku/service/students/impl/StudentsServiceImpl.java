package com.lys.zhku.service.students.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.zhku.mapper.DormitoryMapper;
import com.lys.zhku.mapper.StudentsMapper;
import com.lys.zhku.mapper.UserdetailsMapper;
import com.lys.zhku.model.Dormitory;
import com.lys.zhku.model.Students;
import com.lys.zhku.model.Userdetails;
import com.lys.zhku.model.Users;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.students.StudentsService;
import com.lys.zhku.service.users.UsersService;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.ModelUtils;
import com.lys.zhku.utils.PasswordUtils;
import com.lys.zhku.utils.StatusCode;

@Service
public class StudentsServiceImpl implements StudentsService {

	@Autowired
	private StudentsMapper studentsMapper;
	
	@Autowired
	private UserdetailsMapper userdetailsMapper;
	
	@Autowired
	private UsersService usersService;

	@Override
	public Integer insertStudent(Students student, Userdetails userdetail) {
		//检查model
		if(!(ModelUtils.isNotNullForAllNotNullField(student) && ModelUtils.isNotNullForAllNotNullField(userdetail))) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "缺失必要字段");
		}
		
		//插入用户
		Users users = new Users();
		users.setEnable(true);
		users.setNickname(student.getName());
		users.setPassword(PasswordUtils.DEFAULT_PASSWORD);
		users.setUsername(student.getUsersUsername());
		Integer userStatus = usersService.insertUserForStudents(users);
		if(userStatus==0) {
			throw new ErrorException(StatusCode.EXIST, "账号已存在");
		}
		//插入students
		int studentStatus = studentsMapper.insert(student);
		//插入userDetails
		int userdetailStatus = userdetailsMapper.insert(userdetail);
		
		
		if(studentStatus+userdetailStatus<2) {
			throw new ErrorException(StatusCode.ERROR, "插入数据 发生内部错误");
		}
		
		return StatusCode.SUCCESS;
	}

	@Override
	public Page<Students> getStudentsPage(Pagination pagination) {
		if(pagination.isIllegal()) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "传入的数据参数有错");
		}
		Page<Students> page = new Page<>();
		int total = studentsMapper.selectTotalForPagination(pagination);
		page.setTotal(total);
		if(total<1) {
			page.setRows(new ArrayList<Students>());
			return page;
		}
		List<Students> list = studentsMapper.selectForPagination(pagination);
		page.setRows(list);
		return page;
	}

	@Override
	public Integer updateStudent(Students student, Userdetails userdetail) {
		//检查model
		if(!(ModelUtils.isNotNullForAllNotNullField(student) && ModelUtils.isNotNullForAllNotNullField(userdetail))) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "缺失必要字段");
		}
		
		//更新students
		int studentStatus = studentsMapper.updateByPrimaryKey(student);
		//更新userDetails
		int userdetailStatus = userdetailsMapper.updateByPrimaryKey(userdetail);

		if(studentStatus+userdetailStatus<2) {
			throw new ErrorException(StatusCode.ERROR, "更新数据 发生内部错误");
		}
		
		return StatusCode.SUCCESS;
	}

	@Override
	public Integer deleteStudentsByUsersUsernames(String[] usersUsernames) {
		//错误逻辑交给usersService.updateUserEnableByUsernames方法处理
		return usersService.updateUserEnableByUsernames(usersUsernames, false);
	}

	@Override
	public List<Students> getAll() {
		return studentsMapper.selectAll();
	}

	@Override
	public List<Students> getByPrimaryKeys(String[] pks) {
		if(CollectionUtils.isEmpty(pks)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return studentsMapper.selectByPrimaryKeys(pks);
	}
}
