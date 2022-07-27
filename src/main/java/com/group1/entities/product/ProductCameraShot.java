package com.group1.entities.product;

import java.io.Serializable;
import java.util.Arrays;

public class ProductCameraShot implements Serializable{

	private Integer id;

	private Product productCameraShotIdentifier;

	private String productID;

	private byte[] image;

	private String imageType;

	private String toShowImage;
	
	public ProductCameraShot() {
	}

	public ProductCameraShot(Integer id, Product productCameraShotIdentifier, String productID,
			byte[] image, String imageType, String toShowImage) {
		super();
		this.id = id;
		this.productCameraShotIdentifier = productCameraShotIdentifier;
		this.productID = productID;
		this.image = image;
		this.imageType = imageType;
		this.toShowImage = toShowImage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductCameraShotIdentifier() {
		return productCameraShotIdentifier;
	}

	public void setProductCameraShotIdentifier(Product productCameraShotIdentifier) {
		this.productCameraShotIdentifier = productCameraShotIdentifier;
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
		return "id=" + id
				+ "\n       productID=" + productID + "\n       imageType="
				+ imageType;
	}
	
}
