package com.lys.zhku.model;

public class GroupMembers {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column group_members.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column group_members.group_id
     *
     * @mbg.generated
     */
    private Long groupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column group_members.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column group_members.id
     *
     * @return the value of group_members.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column group_members.id
     *
     * @param id the value for group_members.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column group_members.group_id
     *
     * @return the value of group_members.group_id
     *
     * @mbg.generated
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column group_members.group_id
     *
     * @param groupId the value for group_members.group_id
     *
     * @mbg.generated
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column group_members.username
     *
     * @return the value of group_members.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column group_members.username
     *
     * @param username the value for group_members.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username;
    }
}