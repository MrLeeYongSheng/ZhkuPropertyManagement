package com.lys.zhku.pojo.web;

public class StudentsPagination extends Pagination {

	private String dormitory;
	private String dormitoryLike;
	private String campus;

	public String getDormitory() {
		return dormitory;
	}

	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}

	public String getDormitoryLike() {
		return dormitoryLike;
	}

	public void setDormitoryLike(String dormitoryLike) {
		this.dormitoryLike = dormitoryLike;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

}
