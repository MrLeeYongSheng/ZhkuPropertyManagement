package com.lys.zhku.common;

import org.junit.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class CommonTest {

	@Test
	public void test() {
		StandardPasswordEncoder se = new StandardPasswordEncoder();
		String encode = se.encode("123456");
		System.out.println(encode);
	}//b707e2640a78bc251a877f3d77210084a528ef931ce908f4ee78f3508dae7546b227baa3608e30ee
}
