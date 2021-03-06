package com.lys.zhku.mapper;

import com.lys.zhku.model.Users;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UsersMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(String username);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated
	 */
	int insert(Users record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated
	 */
	Users selectByPrimaryKey(String username);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated
	 */
	List<Users> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table users
	 * @mbg.generated
	 */
	int updateByPrimaryKey(Users record);
	
	int updateEnableByPrimarykeys(@Param("usernames")String[] usernames, @Param("enable") boolean enable);

	/**
	 * 根据主键数组删除记录,内存上删除
	 * @param usernames
	 * @return
	 */
	int deleteByPrimaryKeys(@Param("usernames") String[] usernames);
}