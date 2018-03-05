package com.lys.zhku.pojo.web;

public class Message {

	private Integer code;
	private String msg;

	public Message(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Message() {
		super();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
