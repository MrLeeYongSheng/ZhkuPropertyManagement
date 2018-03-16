package com.lys.zhku.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Park {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column park.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column park.site_num
     *
     * @mbg.generated
     */
    @NotNull
    private String siteNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column park.car_num
     *
     * @mbg.generated
     */
    private String carNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column park.campus
     *
     * @mbg.generated
     */
    @NotNull
    private String campus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column park.entry_time
     *
     * @mbg.generated
     */
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date entryTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column park.book
     *
     * @mbg.generated
     */
    @NotNull
    private Boolean book;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column park.enable
     *
     * @mbg.generated
     */
    @NotNull
    private Boolean enable;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column park.id
     *
     * @return the value of park.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column park.id
     *
     * @param id the value for park.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column park.site_num
     *
     * @return the value of park.site_num
     *
     * @mbg.generated
     */
    public String getSiteNum() {
        return siteNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column park.site_num
     *
     * @param siteNum the value for park.site_num
     *
     * @mbg.generated
     */
    public void setSiteNum(String siteNum) {
        this.siteNum = siteNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column park.car_num
     *
     * @return the value of park.car_num
     *
     * @mbg.generated
     */
    public String getCarNum() {
        return carNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column park.car_num
     *
     * @param carNum the value for park.car_num
     *
     * @mbg.generated
     */
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column park.campus
     *
     * @return the value of park.campus
     *
     * @mbg.generated
     */
    public String getCampus() {
        return campus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column park.campus
     *
     * @param campus the value for park.campus
     *
     * @mbg.generated
     */
    public void setCampus(String campus) {
        this.campus = campus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column park.entry_time
     *
     * @return the value of park.entry_time
     *
     * @mbg.generated
     */
    public Date getEntryTime() {
        return entryTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column park.entry_time
     *
     * @param entryTime the value for park.entry_time
     *
     * @mbg.generated
     */
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column park.book
     *
     * @return the value of park.book
     *
     * @mbg.generated
     */
    public Boolean getBook() {
        return book;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column park.book
     *
     * @param book the value for park.book
     *
     * @mbg.generated
     */
    public void setBook(Boolean book) {
        this.book = book;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column park.enable
     *
     * @return the value of park.enable
     *
     * @mbg.generated
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column park.enable
     *
     * @param enable the value for park.enable
     *
     * @mbg.generated
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}