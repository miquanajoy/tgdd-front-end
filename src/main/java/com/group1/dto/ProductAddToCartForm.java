package com.group1.dto;

public class ProductAddToCartForm {

	public String productID;
	
	private String productName;
	
	private Integer colorID;
	
	private String colorName;
	
	private Integer quantity;
	
	private Integer price;
	
	public ProductAddToCartForm() {
		
	}
	
	public ProductAddToCartForm(String productID, String productName, Integer colorID, String colorName,
			Integer quantity, Integer price) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.colorID = colorID;
		this.colorName = colorName;
		this.quantity = quantity;
		this.price = price;
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

	public Integer getColorID() {
		return colorID;
	}

	public void setColorID(Integer colorID) {
		this.colorID = colorID;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return productID + "," + productName + "," + colorID + "," + colorName + "," + quantity + "," + price;
	}

	
}
