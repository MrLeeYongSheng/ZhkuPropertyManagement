package com.lys.zhku.pojo.web;

public class PersonalFilesPagination extends Pagination {

	private String usersUsername;
	
	private String positionPrefixLike;

	public String getUsersUsername() {
		return usersUsername;
	}

	public void setUsersUsername(String usersUsername) {
		this.usersUsername = usersUsername;
	}

	public String getPositionPrefixLike() {
		return positionPrefixLike;
	}

	public void setPositionPrefixLike(String positionPrefixLike) {
		this.positionPrefixLike = positionPrefixLike;
	}

}
