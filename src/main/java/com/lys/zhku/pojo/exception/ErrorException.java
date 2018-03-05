package com.lys.zhku.pojo.exception;

public class ErrorException extends RuntimeException {
	/**
	 * 自动生成
	 */
	private static final long serialVersionUID = 1900617545890617899L;
	private Integer code;
	private String msg;

	public ErrorException() {
		super();
	}

	public ErrorException(Integer code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
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
