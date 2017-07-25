package com.js.intbuffetproject.model;

public class SearchParameter {
	
	private Long categoryID;
	
	//true means vevegetarian, false - not vegetarian
	private boolean vegetarian;
	
	private String searchText;

	public SearchParameter() {
		
	}

	public SearchParameter(Long categoryID, boolean vegetarian, String searchText) {
		super();
		this.categoryID = categoryID;
		this.vegetarian = vegetarian;
		this.searchText = searchText;
	}

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public boolean getVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	
	

}
