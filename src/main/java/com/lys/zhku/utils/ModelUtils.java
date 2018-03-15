package com.lys.zhku.utils;

import com.lys.zhku.model.Authorities;
import com.lys.zhku.model.Classroom;
import com.lys.zhku.model.ClassroomSchedule;
import com.lys.zhku.model.Datadict;
import com.lys.zhku.model.Dormitory;
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

	public static boolean isNotNullForAllNotNullFieldExceptPrimaryKey(Datadict datadict) {
		return !(datadict.getEnable()==null ||
				StringUtils.isEmpty(datadict.getKey()) || StringUtils.isEmpty(datadict.getValue()));
	}

	public static boolean isNotNullForAllNotNullField(Datadict datadict) {
		return !(datadict.getId()==null || datadict.getEnable()==null ||
				StringUtils.isEmpty(datadict.getKey()) || StringUtils.isEmpty(datadict.getValue()));
	}

	public static boolean isNotNullForAllNotNullFieldExceptPrimaryKey(Dormitory dormitory) {
		return !(StringUtils.isEmpty(dormitory.getCampus()) || StringUtils.isEmpty(dormitory.getName()) ||
				dormitory.getMaxNumber()==null || dormitory.getNumber()==null || dormitory.getEnable()==null);
	}

	public static boolean isNotNullForAllNotNullField(Dormitory dormitory) {
		return !(dormitory.getId()==null || dormitory.getEnable()==null || 
				StringUtils.isEmpty(dormitory.getCampus()) || StringUtils.isEmpty(dormitory.getName()) ||
				dormitory.getMaxNumber()==null || dormitory.getNumber()==null);
	}

	public static boolean isNotNullForAllNotNullFieldExceptPrimaryKey(Classroom classroom) {
		return !(classroom.getEnable()==null || StringUtils.isEmpty(classroom.getCampus()) || 
				StringUtils.isEmpty(classroom.getClassname()));
	}

	public static boolean isNotNullForAllNotNullField(Classroom classroom) {
		return !(classroom.getId()==null || !isNotNullForAllNotNullFieldExceptPrimaryKey(classroom));
	}

	public static boolean isNotNullForAllNotNullFieldExceptPrimaryKey(ClassroomSchedule cs) {
		return !(cs.getClassroomId()== null || cs.getDate()==null || cs.getEnable()==null ||
				cs.getC1()==null || cs.getC2()==null || cs.getC3()==null || cs.getC4()==null ||
				cs.getC5()==null || cs.getC6()==null || cs.getC7()==null || cs.getC8()==null ||
				cs.getC9()==null || cs.getC10()==null || cs.getC11()==null || cs.getC12()==null);
	}

	public static boolean isNotNullForAllNotNullField(ClassroomSchedule cs) {
		return !(cs.getId()==null || !isNotNullForAllNotNullFieldExceptPrimaryKey(cs));
	}
}
