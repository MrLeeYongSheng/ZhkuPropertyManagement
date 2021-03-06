package com.lys.zhku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lys.zhku.mapper.base.BaseMapper;
import com.lys.zhku.model.PersonalFiles;
import com.lys.zhku.pojo.query.FileQuery;

public interface PersonalFilesMapper extends BaseMapper<PersonalFiles>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal_files
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal_files
     *
     * @mbg.generated
     */
    int insert(PersonalFiles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal_files
     *
     * @mbg.generated
     */
    PersonalFiles selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal_files
     *
     * @mbg.generated
     */
    List<PersonalFiles> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table personal_files
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PersonalFiles record);
    
	/**
	 * 根据id获取uuidName和Position
	 * @param ids
	 * @return
	 */
	List<PersonalFiles> selectUuidNameAndPositionByPrimaryKeys(@Param("pks") Integer[] ids);

	/**
	 * 批量插入
	 * @param filesList
	 * @return
	 */
	int insertFiles(@Param("filesList") List<PersonalFiles> filesList);

	/**
	 * 根据外键usersUsername(Users.username的主键)获取记录
	 * @param usersUsername
	 * @return
	 */
	List<PersonalFiles> selectPositionByUsersUsername(String usersUsername);

	/**
	 * 根据FileQuery来获取数据
	 * @param fileQuery
	 * @return
	 */
	List<PersonalFiles> selectPositionByFileQuery(FileQuery fileQuery);
}