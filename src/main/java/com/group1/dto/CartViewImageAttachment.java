package com.group1.dto;

public class CartViewImageAttachment {

	private String forProductID;
	
	private Integer forColorID;
	
	private byte[] image;
	
	private String imageToShow;
	
	public CartViewImageAttachment() {
		
	}

	public CartViewImageAttachment(String forProductID, Integer forColorID, byte[] image, String imageToShow) {
		super();
		this.forProductID = forProductID;
		this.forColorID = forColorID;
		this.image = image;
		this.imageToShow = imageToShow;
	}

	public String getForProductID() {
		return forProductID;
	}

	public void setForProductID(String forProductID) {
		this.forProductID = forProductID;
	}
	
	public Integer getForColorID() {
		return forColorID;
	}

	public void setForColorID(Integer forColorID) {
		this.forColorID = forColorID;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageToShow() {
		return imageToShow;
	}

	public void setImageToShow(String imageToShow) {
		this.imageToShow = imageToShow;
	}

	@Override
	public String toString() {
		return "forProductID=" + forProductID + "forColorID=" + forColorID;
	}

}
