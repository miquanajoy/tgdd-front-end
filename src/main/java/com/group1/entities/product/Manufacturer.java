package com.group1.entities.product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Manufacturer{

	private Integer manufacturerID;
	
	private String manufacturerName;
	
	private byte[] icon;
	
	private Set<Product> ProductList;
	
	private Category cateIDReferrence;
	
	private Integer categoryID;

	private Boolean enabled;
	
	public Manufacturer() {
	}

	public Manufacturer(Integer manufacturerID, String manufacturerName, byte[] icon, Set<Product> productList,
			Category cateIDReferrence, Integer categoryID, Boolean enabled) {
		super();
		this.manufacturerID = manufacturerID;
		this.manufacturerName = manufacturerName;
		this.icon = icon;
		ProductList = productList;
		this.cateIDReferrence = cateIDReferrence;
		this.categoryID = categoryID;
		this.enabled = enabled;
	}

	public Integer getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(Integer manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

	public Set<Product> getProductList() {
		return ProductList;
	}

	public void setProductList(Set<Product> productList) {
		ProductList = productList;
	}

	public Category getCateIDReferrence() {
		return cateIDReferrence;
	}

	public void setCateIDReferrence(Category cateIDReferrence) {
		this.cateIDReferrence = cateIDReferrence;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "manufacturerID=" + manufacturerID + "\n       manufacturerName=" + manufacturerName 
				+ "\n       categoryID=" + categoryID + "\n       enabled=" + enabled;
	}

}
