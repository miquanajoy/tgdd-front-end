package com.group1.entities.product;

import java.io.Serializable;
import java.util.Arrays;

public class ProductUnboxingReview implements Serializable {

	private Integer id;

	private Product productUnboxingReviewIdentifier;

	private String productID;

	private byte[] image;

	private String imageType;

	private String toShowImage;
	
	public ProductUnboxingReview() {
	}

	public ProductUnboxingReview(Integer id, Product productUnboxingReviewIdentifier, String productID, byte[] image, 
			String imageType, String toShowImage) {
		super();
		this.id = id;
		this.productUnboxingReviewIdentifier = productUnboxingReviewIdentifier;
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

	public Product getProductUnboxingReviewIdentifier() {
		return productUnboxingReviewIdentifier;
	}

	public void setProductUnboxingReviewIdentifier(Product productUnboxingReviewIdentifier) {
		this.productUnboxingReviewIdentifier = productUnboxingReviewIdentifier;
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
