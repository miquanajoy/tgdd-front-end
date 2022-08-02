package com.group1.entities.shopping;

import java.io.Serializable;

import com.group1.entities.product.Product;

public class BillDetail implements Serializable {

	private Integer id;

	private ShoppingBill billIdentifier;

	private Integer billId;
	
	private Product productidentifier;

	private Product productId;

	private Integer quantity;

	public BillDetail() {
	}

	public BillDetail(Integer id, ShoppingBill billIdentifier, Integer billId, Product productidentifier,
			Product productId, Integer quantity) {
		super();
		this.id = id;
		this.billIdentifier = billIdentifier;
		this.billId = billId;
		this.productidentifier = productidentifier;
		this.productId = productId;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ShoppingBill getBillIdentifier() {
		return billIdentifier;
	}

	public void setBillIdentifier(ShoppingBill billIdentifier) {
		this.billIdentifier = billIdentifier;
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public Product getProductidentifier() {
		return productidentifier;
	}

	public void setProductidentifier(Product productidentifier) {
		this.productidentifier = productidentifier;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "id=" + id + "\n       billIdentifier=" + billIdentifier + "\n       billId=" + billId
				+ "\n       productidentifier=" + productidentifier + "\n       productId=" + productId
				+ "\n       quantity=" + quantity;
	}


}

