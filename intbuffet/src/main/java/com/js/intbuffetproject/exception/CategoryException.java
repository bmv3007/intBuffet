package com.js.intbuffetproject.exception;

public class CategoryException 	extends RuntimeException{
		   private String exceptionMsg;
		   
		   public CategoryException(String exceptionMsg) {
		      this.exceptionMsg = exceptionMsg;
		   }
		   
		   public String getExceptionMsg() {
		      return this.exceptionMsg;
		   }
		   
		   public void setExceptionMsg(String exceptionMsg) {
		      this.exceptionMsg = exceptionMsg;
		   }
		}