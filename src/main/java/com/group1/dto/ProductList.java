package com.group1.dto;

import java.io.Serializable;

public class ProductList implements Serializable{

	private String productID;
	
	private String productName;
	
	private Integer price;
	
	private Integer manufacturerID;
	
	private Integer categoryID;
	
	private Integer productWarranty;
	
	private byte[] image;
	
	private String imageType;
	
	private double interestRate;
	
	private Boolean exclusive;
	
	private String accessoriesIncluded;

	private Boolean enabled;

	private String imageToShow;
		
	public ProductList() {

	}

	public ProductList(String productID, String productName, Integer price, Integer manufacturerID, Integer categoryID,
			Integer productWarranty, byte[] image, String imageType, double interestRate, Boolean exclusive,
			String accessoriesIncluded, Boolean enabled, String imageToShow) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.manufacturerID = manufacturerID;
		this.categoryID = categoryID;
		this.productWarranty = productWarranty;
		this.image = image;
		this.imageType = imageType;
		this.interestRate = interestRate;
		this.exclusive = exclusive;
		this.accessoriesIncluded = accessoriesIncluded;
		this.enabled = enabled;
		this.imageToShow = imageToShow;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(Integer manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public Integer getProductWarranty() {
		return productWarranty;
	}

	public void setProductWarranty(Integer productWarranty) {
		this.productWarranty = productWarranty;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Boolean getExclusive() {
		return exclusive;
	}

	public void setExclusive(Boolean exclusive) {
		this.exclusive = exclusive;
	}

	public String getAccessoriesIncluded() {
		return accessoriesIncluded;
	}

	public void setAccessoriesIncluded(String accessoriesIncluded) {
		this.accessoriesIncluded = accessoriesIncluded;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getImageToShow() {
		return imageToShow;
	}

	public void setImageToShow(String imageToShow) {
		this.imageToShow = imageToShow;
	}

	@Override
	public String toString() {
		return "productID=" + productID + "\n       productName=" + productName + "\n       price=" + price
				+ "\n       manufacturerID=" + manufacturerID + "\n       categoryID=" + categoryID
				+ "\n       productWarranty=" + productWarranty + "\n       imageType=" + imageType
				+ "\n       interestRate=" + interestRate + "\n       exclusive=" + exclusive
				+ "\n       accessoriesIncluded=" + accessoriesIncluded + "\n       enabled=" + enabled;
	}

	
}
