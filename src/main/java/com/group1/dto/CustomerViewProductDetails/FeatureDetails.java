package com.group1.dto.CustomerViewProductDetails;

public class FeatureDetails {

	private byte[] image;

	public String toShowImage;
	
	public FeatureDetails() {
		
	}

	public FeatureDetails(byte[] image, String toShowImage) {
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
