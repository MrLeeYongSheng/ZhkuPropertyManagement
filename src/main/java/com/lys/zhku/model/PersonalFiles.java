package com.lys.zhku.model;

import com.lys.zhku.anno.NameMapping;

@NameMapping("个人文件信息表")
public class PersonalFiles extends Files{
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column personal_files.users_username
     *
     * @mbg.generated
     */
    private String usersUsername;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column personal_files.users_username
     *
     * @return the value of personal_files.users_username
     *
     * @mbg.generated
     */
    public String getUsersUsername() {
        return usersUsername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column personal_files.users_username
     *
     * @param usersUsername the value for personal_files.users_username
     *
     * @mbg.generated
     */
    public void setUsersUsername(String usersUsername) {
        this.usersUsername = usersUsername;
    }

	/**
	 * 根据Files转换为PersonalFiles
	 * @param f
	 * @return
	 */
	public PersonalFiles convertFromFiles(Files f) {
		if(f==null) {
			return this;
		}
		this.setEnable(f.getEnable());
		this.setId(f.getId());
		this.setName(f.getName());
		this.setParentDir(f.getParentDir());
		this.setPosition(f.getPosition());
		this.setSize(f.getSize());
		this.setTime(f.getTime());
		this.setUuidName(f.getUuidName());
		return this;
	}
}