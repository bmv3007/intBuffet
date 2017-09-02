package com.js.intbuffetproject.util;

/**
 * Class SearchParameter with properties <b>categoryID</b>, <b>vegetarian</b>,
 * <b>searchText</b>, <b>priceFrom</b>, <b>priceTo</b>. It holds parameters for
 * searching.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
public class SearchParameter {

	private Long categoryID;

	// true means vevegetarian, false - not vegetarian
	private boolean vegetarian;

	private String searchText;

	private int priceFrom;

	private int priceTo;

	public SearchParameter() {

	}

	public SearchParameter(Long categoryID, boolean vegetarian, String searchText, int priceFrom, int priceTo) {
		super();
		this.categoryID = categoryID;
		this.vegetarian = vegetarian;
		this.searchText = searchText;
		this.priceFrom = priceFrom;
		this.priceTo = priceTo;
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

	public int getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(int priceFrom) {
		this.priceFrom = priceFrom;
	}

	public int getPriceTo() {
		return priceTo;
	}

	public void setPriceTo(int priceTo) {
		this.priceTo = priceTo;
	}

}
