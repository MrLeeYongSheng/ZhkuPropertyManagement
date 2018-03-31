package com.lys.zhku.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lys.zhku.model.Workers;
import com.lys.zhku.pojo.web.Pagination;

public interface BaseMapper<T> {
	
	/**
	 * 自动生成mapper的方法
	 * @param record
	 * @return
	 */
	int insert(T record);
	
	/**
	 * 自动生成mapper的方法
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(T record);
	
	
	/*
	 * 自动生成的分界线************************************************
	 */

	/**
	 * 根据分页参数查找总记录数
	 * @param pagination
	 * @return
	 */
	int selectCountByPagination(Pagination pagination);

	/**
	 * 根据分页参数查找记录
	 * @param pagination
	 * @return
	 */
	List<T> selectByPagination(Pagination pagination);

	/**
	 * 根据主键数组删除记录
	 * @param ids
	 * @return
	 */
	int deleteByPrimaryKeys(@Param("ids") Integer[] ids);
	
	/**
	 * 获取所有记录的方法
	 * @param record
	 * @return
	 */

	List<T> getAll();
	/**
	 * 根据主键数组获取对应的记录
	 * @param <E> 主键的类型
	 * @param pks
	 * @return
	 */
	<E> List<T> selectByPrimaryKeys(@Param("pks") E[] pks);
}
