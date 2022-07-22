package com.group1.entities.product;

import java.io.Serializable;


public class ProductVariant implements Serializable {

	private Integer id;
	
	private Product productVariantIdentifier;

	private String productVariantID;

	private Product productOrigin;

	private String productOriginalIdentifier;

	private String productVariantName;

	public ProductVariant() {
	}

	public ProductVariant(Integer id, Product productVariantIdentifier, String productVariantID, Product productOrigin,
			String productOriginalIdentifier, String productVariantName) {
		super();
		this.id = id;
		this.productVariantIdentifier = productVariantIdentifier;
		this.productVariantID = productVariantID;
		this.productOrigin = productOrigin;
		this.productOriginalIdentifier = productOriginalIdentifier;
		this.productVariantName = productVariantName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductVariantIdentifier() {
		return productVariantIdentifier;
	}

	public void setProductVariantIdentifier(Product productVariantIdentifier) {
		this.productVariantIdentifier = productVariantIdentifier;
	}

	public String getProductVariantID() {
		return productVariantID;
	}

	public void setProductVariantID(String productVariantID) {
		this.productVariantID = productVariantID;
	}

	public Product getProductOrigin() {
		return productOrigin;
	}

	public void setProductOrigin(Product productOrigin) {
		this.productOrigin = productOrigin;
	}

	public String getProductOriginalIdentifier() {
		return productOriginalIdentifier;
	}

	public void setProductOriginalIdentifier(String productOriginalIdentifier) {
		this.productOriginalIdentifier = productOriginalIdentifier;
	}

	public String getProductVariantName() {
		return productVariantName;
	}

	public void setProductVariantName(String productVariantName) {
		this.productVariantName = productVariantName;
	}

	@Override
	public String toString() {
		return "ProductVariant:\n\tid=" + id + " \n\tproductVariantID=" + productVariantID
				+ " \n\tproductOriginalIdentifier=" + productOriginalIdentifier + " \n\tproductVariantName="
				+ productVariantName;
	}

	
}
