package com.lys.zhku.mapper;

import com.lys.zhku.mapper.base.BaseMapper;
import com.lys.zhku.model.Files;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FilesMapper extends BaseMapper<Files>{

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbg.generated
	 */
	int insert(Files record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbg.generated
	 */
	Files selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbg.generated
	 */
	List<Files> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbg.generated
	 */
	int updateByPrimaryKey(Files record);

	/**
	 * 批量插入
	 * @param filesList
	 * @return
	 */
	int insertFiles(@Param("filesList") List<Files> filesList);

	/**
	 * 根据id获取uuidName和Position
	 * @param ids
	 * @return
	 */
	List<Files> selectUuidNameAndPositionByPrimaryKeys(@Param("ids") Integer[] ids);
}