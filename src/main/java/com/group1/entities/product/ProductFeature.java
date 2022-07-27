package com.group1.entities.product;

import java.io.Serializable;
import java.util.Arrays;

public class ProductFeature implements Serializable{

	private Integer id;

	private Product productFeatureIdentifier;

	private String productID;

	private byte[] image;

	private String imageType;

	private String toShowImage;
	
	public ProductFeature() {
	}

	public ProductFeature(Integer id, Product productFeatureIdentifier, String productID,
			byte[] image, String imageType, String toShowImage) {
		super();
		this.id = id;
		this.productFeatureIdentifier = productFeatureIdentifier;
		this.productID = productID;
		this.image = image;
		this.imageType = imageType ;
		this.toShowImage = toShowImage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductFeatureIdentifier() {
		return productFeatureIdentifier;
	}

	public void setProductFeatureIdentifier(Product productFeatureIdentifier) {
		this.productFeatureIdentifier = productFeatureIdentifier;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
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
	
	public String getToShowImage() {
		return toShowImage;
	}

	public void setToShowImage(String toShowImage) {
		this.toShowImage = toShowImage;
	}

	@Override
	public String toString() {
		return "id=" + id + "\n       productID=" + productID + "\n       imageType=" + imageType;
	}

	
}
