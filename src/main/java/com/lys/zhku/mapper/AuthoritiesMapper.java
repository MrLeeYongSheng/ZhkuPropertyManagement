package com.lys.zhku.mapper;

import com.lys.zhku.model.Authorities;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AuthoritiesMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table authorities
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table authorities
	 * @mbg.generated
	 */
	int insert(Authorities record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table authorities
	 * @mbg.generated
	 */
	Authorities selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table authorities
	 * @mbg.generated
	 */
	List<Authorities> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table authorities
	 * @mbg.generated
	 */
	int updateByPrimaryKey(Authorities record);

	List<Authorities> selectByUsersUsername(String username);

	List<Authorities> selectAllByEnable(boolean enable);

	Authorities selectByAuthority(String authority);

	int deleteByPrimaryKeys(@Param("ids") Integer[] ids);
}