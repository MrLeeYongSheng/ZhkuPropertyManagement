package com.lys.zhku.service;

import com.lys.zhku.model.Userdetails;

public interface UserDetailsService {
	 Userdetails getUserdetailsByUsersUsername(String usersUsername);
}
