package com.group1.entities.product;

import java.io.Serializable;
import java.util.Set;
import com.group1.entities.store.StoreProductInStock;

public class Color implements Serializable {

	private Integer colorID;
	
	private Set<StoreProductInStock> stockProductsWithColorID;
	
	private String colorName;

	public Color() {
	}

	public Color(Integer colorID, Set<StoreProductInStock> stockProductsWithColorID, String colorName) {
		super();
		this.colorID = colorID;
		this.stockProductsWithColorID = stockProductsWithColorID;
		this.colorName = colorName;
	}

	public Integer getColorID() {
		return colorID;
	}

	public void setColorID(Integer colorID) {
		this.colorID = colorID;
	}

	public Set<StoreProductInStock> getStockProductsWithColorID() {
		return stockProductsWithColorID;
	}

	public void setStockProductsWithColorID(Set<StoreProductInStock> stockProductsWithColorID) {
		this.stockProductsWithColorID = stockProductsWithColorID;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	@Override
	public String toString() {
		return "colorID=" + colorID + "\n       stockProductsWithColorID=" + stockProductsWithColorID
				+ "\n       colorName=" + colorName;
	}


}
