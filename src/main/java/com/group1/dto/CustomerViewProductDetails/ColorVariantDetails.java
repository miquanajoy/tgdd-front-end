package com.group1.dto.CustomerViewProductDetails;

public class ColorVariantDetails {

	private Integer colorID;
	
	private String colorName;
	
	private byte[] image;
	
	public String toShowImage;
	
	public ColorVariantDetails() {

	}

	public ColorVariantDetails(Integer colorID, String colorName, byte[] image, String toShowImage) {
		super();
		this.colorID = colorID;
		this.colorName = colorName;
		this.image = image;
		this.toShowImage = toShowImage;
	}

	public Integer getColorID() {
		return colorID;
	}

	public String getColorName() {
		return colorName;
	}

	public byte[] getImage() {
		return image;
	}

	public String getToShowImage() {
		return toShowImage;
	}

	@Override
	public String toString() {
		return "colorID=" + colorID + "\n       colorName=" + colorName ;
	}

}
