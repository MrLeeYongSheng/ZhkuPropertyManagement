package com.lys.zhku.service.users;

import com.lys.zhku.model.Users;

public interface UsersService {

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
}
