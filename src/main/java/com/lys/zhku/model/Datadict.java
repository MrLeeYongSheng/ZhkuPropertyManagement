package com.lys.zhku.model;

import java.io.Serializable;

import com.lys.zhku.anno.NameMapping;

@NameMapping("数据字典")
public class Datadict implements Serializable{
    /**
	 * 自动生成
	 */
	private static final long serialVersionUID = 6653779481217962795L;

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column datadict.id
     *
     * @mbg.generated
     */
	@NameMapping("id")
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column datadict.key
     *
     * @mbg.generated
     */
	@NameMapping("键")
    private String key;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column datadict.value
     *
     * @mbg.generated
     */
	@NameMapping("值")
    private String value;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column datadict.parentId
     *
     * @mbg.generated
     */
	@NameMapping("父级id")
    private Integer parentid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column datadict.enable
     *
     * @mbg.generated
     */
	@NameMapping("有效性")
    private Boolean enable;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column datadict.id
     *
     * @return the value of datadict.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column datadict.id
     *
     * @param id the value for datadict.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column datadict.key
     *
     * @return the value of datadict.key
     *
     * @mbg.generated
     */
    public String getKey() {
        return key;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column datadict.key
     *
     * @param key the value for datadict.key
     *
     * @mbg.generated
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column datadict.value
     *
     * @return the value of datadict.value
     *
     * @mbg.generated
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column datadict.value
     *
     * @param value the value for datadict.value
     *
     * @mbg.generated
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column datadict.parentId
     *
     * @return the value of datadict.parentId
     *
     * @mbg.generated
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column datadict.parentId
     *
     * @param parentid the value for datadict.parentId
     *
     * @mbg.generated
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column datadict.enable
     *
     * @return the value of datadict.enable
     *
     * @mbg.generated
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column datadict.enable
     *
     * @param enable the value for datadict.enable
     *
     * @mbg.generated
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

	public Datadict() {
		super();
	}

	public Datadict(Integer id, String key, String value, Integer parentid, Boolean enable) {
		super();
		this.id = id;
		this.key = key;
		this.value = value;
		this.parentid = parentid;
		this.enable = enable;
	}

}