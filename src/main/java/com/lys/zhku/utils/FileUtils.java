package com.lys.zhku.utils;

import java.util.regex.Pattern;

public class FileUtils {

	private FileUtils() {}
	public static final String SEPARATOR = System.getProperty("file.separator","/");
	
	public static String trans2SysSeparator(String orginPath) {
		int lastIndexOf = -1;
		lastIndexOf = orginPath.lastIndexOf("\\");
		if(lastIndexOf>-1 && orginPath.charAt(lastIndexOf)!=SEPARATOR.charAt(0)) {
			return orginPath.replace(orginPath.charAt(lastIndexOf), SEPARATOR.charAt(0));
		} 
		lastIndexOf = orginPath.lastIndexOf("/");
		if(lastIndexOf>-1 && orginPath.charAt(lastIndexOf)!=SEPARATOR.charAt(0)) {
			return orginPath.replace(orginPath.charAt(lastIndexOf), SEPARATOR.charAt(0));
		}
		return orginPath;
	}
	
	/**
	 * @param orginPath
	 * @return 从左往右分割出来的数组
	 */
	public static String[] splitSysSeparator2Array(String orginPath) {
		if(StringUtils.isEmpty(orginPath)) {
			return new String[] {""};
		}
		String regex = SEPARATOR.equals("\\") ? "\\"+SEPARATOR : SEPARATOR;
		if(orginPath.trim().charAt(0)==SEPARATOR.charAt(0)) {
			return orginPath.trim().substring(1).split(regex);
		}
		
		return orginPath.trim().split(regex);
	}
}
