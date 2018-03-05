package com.lys.zhku.utils;

import com.lys.zhku.model.Students;
import com.lys.zhku.model.Userdetails;

public class ModelUtils {
	/**
	 * 检查userdetails表的所要求的非空字段是否没有为""或null
	 * 
	 * @param userdetail
	 * @return
	 */
	public static Boolean isNotNullForAllNotNullField(Userdetails userdetail) {
		return !(StringUtils.isEmpty(userdetail.getUsersUsername()) || StringUtils.isEmpty(userdetail.getIdcard()));
	}
	
	/**
	 * 检查students表的所要求的非空字段是否没有为""或null
	 * @param student
	 * @return
	 */
	public static Boolean isNotNullForAllNotNullField(Students student) {
		return !(StringUtils.isEmpty(student.getUsersUsername()) || StringUtils.isEmpty(student.getName())
				|| StringUtils.isEmpty(student.getGender()) || StringUtils.isEmpty(student.getCampus())
				|| StringUtils.isEmpty(student.getDormitory()));
	}
}
