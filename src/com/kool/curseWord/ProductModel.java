package com.kool.curseWord;

final public class ProductModel {
	private double rating;
	private String customerName;

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public ProductModel() {
	}

	public ProductModel(double rating, String customerName) {
		this.rating = rating;
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "ProductModel{" + "rating= " + rating + ", customerName='" + customerName + '\'' + '}';
	}
}