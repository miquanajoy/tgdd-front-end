package com.group1.entities.store;

import java.io.Serializable;

import com.group1.entities.product.Color;
import com.group1.entities.product.Product;

public class StoreProductInStock implements Serializable {

	private Integer id;

	private Store storeIdentity;

	private Integer storeId;

	private Product productIdentity;

	private Integer productId;

	private Integer quantity;

	private Integer localPrice;

	private Color colorIdentity;

	private Integer colorId;

	public StoreProductInStock() {
	}

	public StoreProductInStock(Integer id, Store storeIdentity, Integer storeId, Product productIdentity,
			Integer productId, Integer quantity, Integer localPrice, Color colorIdentity, Integer colorId) {
		super();
		this.id = id;
		this.storeIdentity = storeIdentity;
		this.storeId = storeId;
		this.productIdentity = productIdentity;
		this.productId = productId;
		this.quantity = quantity;
		this.localPrice = localPrice;
		this.colorIdentity = colorIdentity;
		this.colorId = colorId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Store getStoreIdentity() {
		return storeIdentity;
	}

	public void setStoreIdentity(Store storeIdentity) {
		this.storeIdentity = storeIdentity;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Product getProductIdentity() {
		return productIdentity;
	}

	public void setProductIdentity(Product productIdentity) {
		this.productIdentity = productIdentity;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getLocalPrice() {
		return localPrice;
	}

	public void setLocalPrice(Integer localPrice) {
		this.localPrice = localPrice;
	}

	public Color getColorIdentity() {
		return colorIdentity;
	}

	public void setColorIdentity(Color colorIdentity) {
		this.colorIdentity = colorIdentity;
	}

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	@Override
	public String toString() {
		return "id=" + id + "\n       storeIdentity=" + storeIdentity + "\n       storeId=" + storeId
				+ "\n       productIdentity=" + productIdentity + "\n       productId=" + productId
				+ "\n       quantity=" + quantity + "\n       localPrice=" + localPrice + "\n       colorIdentity="
				+ colorIdentity + "\n       colorId=" + colorId;
	}

}