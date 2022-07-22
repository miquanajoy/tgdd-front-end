package com.group1.entities.product;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class ProductColorVariant implements Serializable {

	private Integer id;
	
	private Product productColorVariantIdentifier;

	private String productID;
 
	private Color color;

	private Integer colorID;

	private byte[] image;

	private String imageType;

	private MultipartFile[] fileDatas;

	private String toShowImage;
	
	public ProductColorVariant() {
	}

	public ProductColorVariant(Integer id, Product productColorVariantIdentifier, String productID, Color color,
			Integer colorID, byte[] image, String imageType, MultipartFile[] fileDatas, String toShowImage) {
		super();
		this.id = id;
		this.productColorVariantIdentifier = productColorVariantIdentifier;
		this.productID = productID;
		this.color = color;
		this.colorID = colorID;
		this.image = image;
		this.imageType = imageType;
		this.fileDatas = fileDatas;
		this.toShowImage = toShowImage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductColorVariantIdentifier() {
		return productColorVariantIdentifier;
	}

	public void setProductColorVariantIdentifier(Product productColorVariantIdentifier) {
		this.productColorVariantIdentifier = productColorVariantIdentifier;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Integer getColorID() {
		return colorID;
	}

	public void setColorID(Integer colorID) {
		this.colorID = colorID;
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

	public MultipartFile[] getFileDatas() {
		return fileDatas;
	}

	public void setFileDatas(MultipartFile[] fileDatas) {
		this.fileDatas = fileDatas;
	}
	
	public String getToShowImage() {
		return toShowImage;
	}

	public void setToShowImage(String toShowImage) {
		this.toShowImage = toShowImage;
	}

	@Override
	public String toString() {
		return "id=" + id + "\n       productID=" + productID + "\n       colorID="
				+ colorID + "\n       imageType=" + imageType;
	}

	

}
