package com.js.intbuffetproject.util;


public class TopClient {
	
	private String user;
	
	private Double sum;

	public TopClient(String user, Double sum) {
		super();
		this.user = user;
		this.sum = sum;
	}

	public TopClient() {
		super();
		
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}
	
	
	

}
