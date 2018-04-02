package com.lys.zhku.service;

import com.lys.zhku.model.Userdetails;

public interface UserDetailsService {
	 Userdetails getUserdetailsByUsersUsername(String usersUsername);

	/**
	 * 根据usersUsername修改记录
	 * @param ud
	 * @return
	 */
	int updateByUsersUsername(Userdetails ud);
}
