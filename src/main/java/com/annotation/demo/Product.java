package com.annotation.demo;
//@StoreNumber
public class Product {

	private String productName;
	@StoreNumber
	private String storeNumber;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	//@StoreNumber
	public String getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}
	
}
