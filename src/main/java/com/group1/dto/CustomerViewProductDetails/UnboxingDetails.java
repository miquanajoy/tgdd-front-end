package com.group1.dto.CustomerViewProductDetails;

public class UnboxingDetails {

	private byte[] image;

	public String toShowImage;
	
	public UnboxingDetails() {
		// TODO Auto-generated constructor stub
	}

	public UnboxingDetails(byte[] image, String toShowImage) {
		super();
		this.image = image;
		this.toShowImage = toShowImage;
	}

	public byte[] getImage() {
		return image;
	}

	public String getToShowImage() {
		return toShowImage;
	}
	
}
