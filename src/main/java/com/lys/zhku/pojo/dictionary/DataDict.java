package com.lys.zhku.pojo.dictionary;

public class DataDict {
	public DataDict() {
	}

	public DataDict(Integer id, String key, String value, String parentId, Boolean enable) {
		super();
		this.id = id;
		this.key = key;
		this.value = value;
		this.parentId = parentId;
		this.enable = enable;
	}

	public Integer id;
	public String key;
	public String value;
	public String parentId;
	public Boolean enable;
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}
