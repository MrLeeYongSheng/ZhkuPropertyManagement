package com.lys.zhku.utils;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordUtils {
	
	public static String DEFAULT_PASSWORD = "123456";

	/**
	 * @param rawPassword 加密前的密码
	 * @return 加密后的密码,若为null或者""则返回null
	 */
	public static String encode(String rawPassword) {
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		if(StringUtils.isEmpty(rawPassword)) {
			return null;
		}
		return encoder.encode(rawPassword);
	}
	
	/**
	 * @param rawPassword 加密前的密码
	 * @param encodedPassword 加密后的密码
	 * @return true: 匹对成功<br>false: 匹对失败<br>
	 * 		   null: rawPassword 或者 encodedPassword为空""或者null<br>
	 */
	public static Boolean matches(String rawPassword, String encodedPassword) {
		
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		if(StringUtils.isEmpty(rawPassword) || StringUtils.isEmpty(encodedPassword)) {
			return null;
		}
		return encoder.matches(rawPassword, encodedPassword);
	}
}
