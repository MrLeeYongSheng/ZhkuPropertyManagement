package com.lys.zhku.mapper;

import com.lys.zhku.model.Students;
import com.lys.zhku.pojo.web.Pagination;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StudentsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table students
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(String usersUsername);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table students
	 * @mbg.generated
	 */
	int insert(Students record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table students
	 * @mbg.generated
	 */
	Students selectByPrimaryKey(String usersUsername);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table students
	 * @mbg.generated
	 */
	List<Students> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table students
	 * @mbg.generated
	 */
	int updateByPrimaryKey(Students record);

	List<Students> selectForPagination(Pagination pagination);
	
	Integer selectTotalForPagination(Pagination pagination);
	
	Integer deleteByPrimaryKeys(@Param("usersUsernames") String[] usersUsernames);
}