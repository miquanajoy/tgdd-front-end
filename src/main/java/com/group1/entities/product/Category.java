package com.group1.entities.product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;
//fixed

public class Category implements Serializable{

	private Integer categoryID;
	
	private Boolean isParent;
	
	private Integer level;
	
	private byte[] icon;
	
	private String categoryName;

	private Integer parentID;
	
	private Boolean enabled;

	private Set<Product> ProductList;

	private Set<Manufacturer> brandList;
	
	private Set<ProductTechSpecs> specList;
	
	public Category() {
	}

	public Category(Integer categoryID, Boolean isParent, Integer level, byte[] icon, String categoryName,
			Integer parentID, Boolean enabled) {
		super();
		this.categoryID = categoryID;
		this.isParent = isParent;
		this.level = level;
		this.icon = icon;
		this.categoryName = categoryName;
		this.parentID = parentID;
		this.enabled = enabled;
	}
	
	public Category(Integer categoryID, Boolean isParent, Integer level, byte[] icon, String categoryName,
			Integer parentID, Boolean enabled, Set<Product> productList, Set<Manufacturer> brandList,
			Set<ProductTechSpecs> specList) {
		super();
		this.categoryID = categoryID;
		this.isParent = isParent;
		this.level = level;
		this.icon = icon;
		this.categoryName = categoryName;
		this.parentID = parentID;
		this.enabled = enabled;
		ProductList = productList;
		this.brandList = brandList;
		this.specList = specList;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Product> getProductList() {
		return ProductList;
	}

	public void setProductList(Set<Product> productList) {
		ProductList = productList;
	}

	public Set<Manufacturer> getBrandList() {
		return brandList;
	}

	public void setBrandList(Set<Manufacturer> brandList) {
		this.brandList = brandList;
	}

	public Set<ProductTechSpecs> getSpecList() {
		return specList;
	}

	public void setSpecList(Set<ProductTechSpecs> specList) {
		this.specList = specList;
	}

	@Override
	public String toString() {
		return "categoryID=" + categoryID + "\n       isParent=" + isParent + "\n       level=" + level
				/*+ "\n       icon=" + Arrays.toString(icon)*/ + "\n       categoryName=" + categoryName
				+ "\n       parentID=" + parentID + "\n       enabled=" + enabled;
	}

	
}
