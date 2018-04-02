package com.lys.zhku.service.users.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.zhku.mapper.RolesMapper;
import com.lys.zhku.mapper.UsersMapper;
import com.lys.zhku.mapper.UsersRolesMapper;
import com.lys.zhku.model.Roles;
import com.lys.zhku.model.Users;
import com.lys.zhku.model.UsersRoles;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.service.users.UsersService;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.ModelUtils;
import com.lys.zhku.utils.PasswordUtils;
import com.lys.zhku.utils.RolesUtils;
import com.lys.zhku.utils.StatusCode;
import com.lys.zhku.utils.StringUtils;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private RolesMapper rolesMapper;

	@Autowired
	private UsersRolesMapper usersRolesMapper;

	/**
	 * @param user 用户,其字段不能为空,其密码为必须为原始密码(本方法提供加密)
	 * @return 0:插入失败,用户已存在<br>1:成功
	 */
	@Override
	public Integer insertUserForStudents(Users user) {
/*		user.setPassword(PasswordUtils.encode(user.getPassword()));
		int userStatus = usersMapper.insert(user);//添加用户
		if(userStatus==0) {
			return StatusCode.EXIST;
		}
		//为用户添加角色
		Roles studentRole = rolesMapper.selectByRole(RolesUtils.STUDENTS);//获取学生角色,目的为了其角色ID
		UsersRoles usersRoles = new UsersRoles();
		usersRoles.setRolesId(studentRole.getId());
		usersRoles.setUsersUsername(user.getUsername());
		usersRolesMapper.insert(usersRoles);
		return StatusCode.SUCCESS;*/
		
		return insertUserForRoles(user, RolesUtils.STUDENTS);
	}

	@Override
	public Integer updateUserEnableByUsernames(String[] usernames, boolean enable) {
		if(CollectionUtils.isEmpty(usernames)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		int status = usersMapper.updateEnableByPrimarykeys(usernames, enable);
		if(status<1) {
			throw new ErrorException(StatusCode.ERROR, "操作失败");
		}
		return status;
	}

	@Override
	public Integer insertUserForworkers(Users user) {
		return insertUserForRoles(user, RolesUtils.WORKERS);
	}
	
	private Integer insertUserForRoles(Users user, String roleName) {
		user.setPassword(PasswordUtils.encode(user.getPassword()));
		int userStatus = usersMapper.insert(user);//添加用户
		if(userStatus==0) {
			return StatusCode.EXIST;
		}
		//为用户添加角色
		Roles role = rolesMapper.selectByRole(roleName);//获取学生角色,目的为了其角色ID
		UsersRoles usersRoles = new UsersRoles();
		usersRoles.setRolesId(role.getId());
		usersRoles.setUsersUsername(user.getUsername());
		return usersRolesMapper.insert(usersRoles);
	}

	@Override
	public int deleteByUsernamesInMemory(String[] usersUsernames) {
		return usersMapper.deleteByPrimaryKeys(usersUsernames);
	}

	@Override
	public Users getByPrimaryKey(String username) {
		if(StringUtils.isEmpty(username)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return usersMapper.selectByPrimaryKey(username);
	}

	@Override
	public int updateByPrimaryKey(Users selectUser) {
		if(!ModelUtils.isNotNullForAllNotNullField(selectUser)) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "不完整的对象信息");
		}
		return usersMapper.updateByPrimaryKey(selectUser);
	}
}
