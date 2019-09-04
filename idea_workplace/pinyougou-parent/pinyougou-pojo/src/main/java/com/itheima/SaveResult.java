package com.itheima;

import java.io.Serializable;

public class SaveResult implements Serializable {
	private String message;
	private boolean success;
	public SaveResult(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	

}
