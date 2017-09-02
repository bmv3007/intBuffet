package com.js.intbuffetproject.exception;

/**
 * FileIsEmptyException is thrown out, wenn file is not selected.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
public class FileIsEmptyException extends Exception {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String exceptionMsg;

	public FileIsEmptyException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return this.exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}