package com.lys.zhku.utils;

import com.lys.zhku.model.Authorities;
import com.lys.zhku.model.Roles;
import com.lys.zhku.model.Students;
import com.lys.zhku.model.Userdetails;
import com.lys.zhku.model.Workers;

public class ModelUtils {
	/**
	 * 检查userdetails表的所要求的非空字段是否没有为""或null
	 * 
	 * @param userdetail
	 * @return
	 */
	public static boolean isNotNullForAllNotNullField(Userdetails userdetail) {
		return !(StringUtils.isEmpty(userdetail.getUsersUsername()) || StringUtils.isEmpty(userdetail.getIdcard()));
	}

	/**
	 * 检查userdetails表的所要求的非空字段是否没有为""或null
	 * 
	 * @param userdetail
	 * @return
	 */
	public static boolean isNotNullForAllNotNullField(Workers worker) {
		return !(StringUtils.isEmpty(worker.getUsersUsername()) || 
				StringUtils.isEmpty(worker.getPosition()) || 
				StringUtils.isEmpty(worker.getName()) ||
				StringUtils.isEmpty(worker.getGender()));
	}
	
	/**
	 * 检查students表的所要求的非空字段是否没有为""或null
	 * @param student
	 * @return
	 */
	public static boolean isNotNullForAllNotNullField(Students student) {
		return !(StringUtils.isEmpty(student.getUsersUsername()) || StringUtils.isEmpty(student.getName())
				|| StringUtils.isEmpty(student.getGender()) || StringUtils.isEmpty(student.getCampus())
				|| StringUtils.isEmpty(student.getDormitory()));
	}
	
	public static boolean isNotNullForAllNotNullFieldExceptPrimaryKey(Roles role) {
		return !(StringUtils.isEmpty(role.getRole()) || role.getEnable()==null);
	}

	public static boolean isNotNullForAllNotNullField(Authorities auth) {
		return !(auth.getId()==null || StringUtils.isEmpty(auth.getAuthority()) || auth.getEnable()==null);
	}

	public static boolean isNotNullForAllNotNullField(Roles role) {
		return !(role.getId()==null || StringUtils.isEmpty(role.getRole()) || role.getEnable()==null);
	}
}
