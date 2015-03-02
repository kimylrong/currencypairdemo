/*
 * Result.java  2015年2月28日
 */
package com.qiusuo.pair.web.api;

/**
 * 返回值
 * 
 * @author Li, Rong
 * @version 1.0
 */
public class Result {
	private String code;
	private String message;
	private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
