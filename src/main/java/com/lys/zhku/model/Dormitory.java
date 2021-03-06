package com.lys.zhku.model;

import com.lys.zhku.anno.NameMapping;

@NameMapping("宿舍表")
public class Dormitory {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dormitory.id
	 * @mbg.generated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dormitory.name
	 * @mbg.generated
	 */
	@NameMapping("宿舍号")
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dormitory.campus
	 * @mbg.generated
	 */
	@NameMapping("校区")
	private String campus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dormitory.number
	 * @mbg.generated
	 */
	@NameMapping("现住成员数")
	private Integer number;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dormitory.max_number
	 * @mbg.generated
	 */
	@NameMapping("最大成员数")
	private Integer maxNumber;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dormitory.enable
	 * @mbg.generated
	 */
	@NameMapping("有效标志")
	private Boolean enable;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dormitory.id
	 * @return  the value of dormitory.id
	 * @mbg.generated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dormitory.id
	 * @param id  the value for dormitory.id
	 * @mbg.generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dormitory.name
	 * @return  the value of dormitory.name
	 * @mbg.generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dormitory.name
	 * @param name  the value for dormitory.name
	 * @mbg.generated
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dormitory.campus
	 * @return  the value of dormitory.campus
	 * @mbg.generated
	 */
	public String getCampus() {
		return campus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dormitory.campus
	 * @param campus  the value for dormitory.campus
	 * @mbg.generated
	 */
	public void setCampus(String campus) {
		this.campus = campus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dormitory.number
	 * @return  the value of dormitory.number
	 * @mbg.generated
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dormitory.number
	 * @param number  the value for dormitory.number
	 * @mbg.generated
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dormitory.max_number
	 * @return  the value of dormitory.max_number
	 * @mbg.generated
	 */
	public Integer getMaxNumber() {
		return maxNumber;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dormitory.max_number
	 * @param maxNumber  the value for dormitory.max_number
	 * @mbg.generated
	 */
	public void setMaxNumber(Integer maxNumber) {
		this.maxNumber = maxNumber;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dormitory.enable
	 * @return  the value of dormitory.enable
	 * @mbg.generated
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dormitory.enable
	 * @param enable  the value for dormitory.enable
	 * @mbg.generated
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}