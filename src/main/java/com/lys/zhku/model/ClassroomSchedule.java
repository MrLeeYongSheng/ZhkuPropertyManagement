package com.lys.zhku.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClassroomSchedule {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.id
	 * @mbg.generated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.classroom_id
	 * @mbg.generated
	 */
	private Integer classroomId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.date
	 * @mbg.generated
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date date;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.enable
	 * @mbg.generated
	 */
	private Boolean enable;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.c1
	 * @mbg.generated
	 */
	private Boolean c1;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.c2
	 * @mbg.generated
	 */
	private Boolean c2;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.c3
	 * @mbg.generated
	 */
	private Boolean c3;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.c4
	 * @mbg.generated
	 */
	private Boolean c4;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.c5
	 * @mbg.generated
	 */
	private Boolean c5;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.c6
	 * @mbg.generated
	 */
	private Boolean c6;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.c7
	 * @mbg.generated
	 */
	private Boolean c7;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.c8
	 * @mbg.generated
	 */
	private Boolean c8;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.c9
	 * @mbg.generated
	 */
	private Boolean c9;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.c10
	 * @mbg.generated
	 */
	private Boolean c10;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.c11
	 * @mbg.generated
	 */
	private Boolean c11;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column classroom_schedule.c12
	 * @mbg.generated
	 */
	private Boolean c12;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.id
	 * @return  the value of classroom_schedule.id
	 * @mbg.generated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.id
	 * @param id  the value for classroom_schedule.id
	 * @mbg.generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.classroom_id
	 * @return  the value of classroom_schedule.classroom_id
	 * @mbg.generated
	 */
	public Integer getClassroomId() {
		return classroomId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.classroom_id
	 * @param classroomId  the value for classroom_schedule.classroom_id
	 * @mbg.generated
	 */
	public void setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.date
	 * @return  the value of classroom_schedule.date
	 * @mbg.generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.date
	 * @param date  the value for classroom_schedule.date
	 * @mbg.generated
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.enable
	 * @return  the value of classroom_schedule.enable
	 * @mbg.generated
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.enable
	 * @param enable  the value for classroom_schedule.enable
	 * @mbg.generated
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.c1
	 * @return  the value of classroom_schedule.c1
	 * @mbg.generated
	 */
	public Boolean getC1() {
		return c1;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.c1
	 * @param c1  the value for classroom_schedule.c1
	 * @mbg.generated
	 */
	public void setC1(Boolean c1) {
		this.c1 = c1;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.c2
	 * @return  the value of classroom_schedule.c2
	 * @mbg.generated
	 */
	public Boolean getC2() {
		return c2;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.c2
	 * @param c2  the value for classroom_schedule.c2
	 * @mbg.generated
	 */
	public void setC2(Boolean c2) {
		this.c2 = c2;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.c3
	 * @return  the value of classroom_schedule.c3
	 * @mbg.generated
	 */
	public Boolean getC3() {
		return c3;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.c3
	 * @param c3  the value for classroom_schedule.c3
	 * @mbg.generated
	 */
	public void setC3(Boolean c3) {
		this.c3 = c3;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.c4
	 * @return  the value of classroom_schedule.c4
	 * @mbg.generated
	 */
	public Boolean getC4() {
		return c4;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.c4
	 * @param c4  the value for classroom_schedule.c4
	 * @mbg.generated
	 */
	public void setC4(Boolean c4) {
		this.c4 = c4;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.c5
	 * @return  the value of classroom_schedule.c5
	 * @mbg.generated
	 */
	public Boolean getC5() {
		return c5;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.c5
	 * @param c5  the value for classroom_schedule.c5
	 * @mbg.generated
	 */
	public void setC5(Boolean c5) {
		this.c5 = c5;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.c6
	 * @return  the value of classroom_schedule.c6
	 * @mbg.generated
	 */
	public Boolean getC6() {
		return c6;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.c6
	 * @param c6  the value for classroom_schedule.c6
	 * @mbg.generated
	 */
	public void setC6(Boolean c6) {
		this.c6 = c6;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.c7
	 * @return  the value of classroom_schedule.c7
	 * @mbg.generated
	 */
	public Boolean getC7() {
		return c7;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.c7
	 * @param c7  the value for classroom_schedule.c7
	 * @mbg.generated
	 */
	public void setC7(Boolean c7) {
		this.c7 = c7;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.c8
	 * @return  the value of classroom_schedule.c8
	 * @mbg.generated
	 */
	public Boolean getC8() {
		return c8;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.c8
	 * @param c8  the value for classroom_schedule.c8
	 * @mbg.generated
	 */
	public void setC8(Boolean c8) {
		this.c8 = c8;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.c9
	 * @return  the value of classroom_schedule.c9
	 * @mbg.generated
	 */
	public Boolean getC9() {
		return c9;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.c9
	 * @param c9  the value for classroom_schedule.c9
	 * @mbg.generated
	 */
	public void setC9(Boolean c9) {
		this.c9 = c9;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.c10
	 * @return  the value of classroom_schedule.c10
	 * @mbg.generated
	 */
	public Boolean getC10() {
		return c10;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.c10
	 * @param c10  the value for classroom_schedule.c10
	 * @mbg.generated
	 */
	public void setC10(Boolean c10) {
		this.c10 = c10;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.c11
	 * @return  the value of classroom_schedule.c11
	 * @mbg.generated
	 */
	public Boolean getC11() {
		return c11;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.c11
	 * @param c11  the value for classroom_schedule.c11
	 * @mbg.generated
	 */
	public void setC11(Boolean c11) {
		this.c11 = c11;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column classroom_schedule.c12
	 * @return  the value of classroom_schedule.c12
	 * @mbg.generated
	 */
	public Boolean getC12() {
		return c12;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column classroom_schedule.c12
	 * @param c12  the value for classroom_schedule.c12
	 * @mbg.generated
	 */
	public void setC12(Boolean c12) {
		this.c12 = c12;
	}
}