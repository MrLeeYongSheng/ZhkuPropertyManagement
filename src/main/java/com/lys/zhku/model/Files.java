package com.lys.zhku.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Files {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column files.id
	 * @mbg.generated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column files.parent_dir
	 * @mbg.generated
	 */
	@NotNull
	private String parentDir;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column files.name
	 * @mbg.generated
	 */
	@NotNull
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column files.uuid_name
	 * @mbg.generated
	 */
	@NotNull
	private String uuidName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column files.size
	 * @mbg.generated
	 */
	private Long size;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column files.time
	 * @mbg.generated
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date time;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column files.enable
	 * @mbg.generated
	 */
	@NotNull
	private Boolean enable;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column files.id
	 * @return  the value of files.id
	 * @mbg.generated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column files.id
	 * @param id  the value for files.id
	 * @mbg.generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column files.parent_dir
	 * @return  the value of files.parent_dir
	 * @mbg.generated
	 */
	public String getParentDir() {
		return parentDir;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column files.parent_dir
	 * @param parentDir  the value for files.parent_dir
	 * @mbg.generated
	 */
	public void setParentDir(String parentDir) {
		this.parentDir = parentDir;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column files.name
	 * @return  the value of files.name
	 * @mbg.generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column files.name
	 * @param name  the value for files.name
	 * @mbg.generated
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column files.uuid_name
	 * @return  the value of files.uuid_name
	 * @mbg.generated
	 */
	public String getUuidName() {
		return uuidName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column files.uuid_name
	 * @param uuidName  the value for files.uuid_name
	 * @mbg.generated
	 */
	public void setUuidName(String uuidName) {
		this.uuidName = uuidName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column files.size
	 * @return  the value of files.size
	 * @mbg.generated
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column files.size
	 * @param size  the value for files.size
	 * @mbg.generated
	 */
	public void setSize(Long size) {
		this.size = size;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column files.time
	 * @return  the value of files.time
	 * @mbg.generated
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column files.time
	 * @param time  the value for files.time
	 * @mbg.generated
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column files.enable
	 * @return  the value of files.enable
	 * @mbg.generated
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column files.enable
	 * @param enable  the value for files.enable
	 * @mbg.generated
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}