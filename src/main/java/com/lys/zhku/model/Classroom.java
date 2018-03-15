package com.lys.zhku.model;

public class Classroom {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom.id
	 * @mbg.generated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom.classname
	 * @mbg.generated
	 */
	private String classname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom.max_number
	 * @mbg.generated
	 */
	private Integer maxNumber;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom.campus
	 * @mbg.generated
	 */
	private String campus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom.enable
	 * @mbg.generated
	 */
	private Boolean enable;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom.id
	 * @return  the value of classroom.id
	 * @mbg.generated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom.id
	 * @param id  the value for classroom.id
	 * @mbg.generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom.classname
	 * @return  the value of classroom.classname
	 * @mbg.generated
	 */
	public String getClassname() {
		return classname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom.classname
	 * @param classname  the value for classroom.classname
	 * @mbg.generated
	 */
	public void setClassname(String classname) {
		this.classname = classname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom.max_number
	 * @return  the value of classroom.max_number
	 * @mbg.generated
	 */
	public Integer getMaxNumber() {
		return maxNumber;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom.max_number
	 * @param maxNumber  the value for classroom.max_number
	 * @mbg.generated
	 */
	public void setMaxNumber(Integer maxNumber) {
		this.maxNumber = maxNumber;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom.campus
	 * @return  the value of classroom.campus
	 * @mbg.generated
	 */
	public String getCampus() {
		return campus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom.campus
	 * @param campus  the value for classroom.campus
	 * @mbg.generated
	 */
	public void setCampus(String campus) {
		this.campus = campus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom.enable
	 * @return  the value of classroom.enable
	 * @mbg.generated
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom.enable
	 * @param enable  the value for classroom.enable
	 * @mbg.generated
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}