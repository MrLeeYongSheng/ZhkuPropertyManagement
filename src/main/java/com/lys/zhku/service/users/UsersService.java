package com.lys.zhku.service.users;

import com.lys.zhku.model.Users;

public interface UsersService {

	/**
	 * @param user 用户,其字段不能为空,其密码为必须为原始密码(本方法提供加密)
	 * @return 0:插入失败,用户已存在<br>1:成功
	 */
	Integer insertUserForStudents(Users user);
	
	/**
	 * 根据username数组来设置其对应记录的enable<br>
	 * 用作逻辑删除:enable=false<br>
	 * 用作逻辑恢复:enable=true
	 * @param usernames
	 * @param enable
	 * @return
	 */
	Integer updateUserEnableByUsernames(String[] usernames, boolean enable);

	/**
	 * @param user 用户,其字段不能为空,其密码为必须为原始密码(本方法提供加密)
	 * @return 0:插入失败,用户已存在<br>1:成功
	 */
	Integer insertUserForworkers(Users user);

	int deleteByUsernamesInMemory(String[] usersUsernames);
}
