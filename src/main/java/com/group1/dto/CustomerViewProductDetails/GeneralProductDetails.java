package com.group1.dto.CustomerViewProductDetails;

import java.util.List;

import com.group1.dto.SpecSection;

public class GeneralProductDetails {

	private String productID;

	private String productName;

	private Integer price;
	
	private Integer manufacturerID;

	private Integer categoryID;

	public ArticleDetails article;

	public List<CameraShotsDetails> cameraShots;

	public List<ColorVariantDetails> colorVariant;

	public List<FeatureDetails> features;
	
	public List<UnboxingDetails> unboxing;

	public List<ProductVariantDetails> original;

	private Integer productWarranty;
	
	private byte[] image;

	private double interestRate;

	private Boolean exclusive;

	private String accessoriesIncluded;

	private Boolean enabled;
	
	public String imageToShow;

	public List<SpecSection> specList;
	
	public GeneralProductDetails() {
		
	}

	public GeneralProductDetails(String productID, String productName, Integer price, Integer manufacturerID,
			Integer categoryID, Integer productWarranty, byte[] image, double interestRate, Boolean exclusive,
			String accessoriesIncluded, Boolean enabled) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.manufacturerID = manufacturerID;
		this.categoryID = categoryID;
		this.productWarranty = productWarranty;
		this.image = image;
		this.interestRate = interestRate;
		this.exclusive = exclusive;
		this.accessoriesIncluded = accessoriesIncluded;
		this.enabled = enabled;
	}



	public GeneralProductDetails(String productID, String productName, Integer price, Integer manufacturerID,
			Integer categoryID, ArticleDetails article, List<CameraShotsDetails> cameraShots,
			List<ColorVariantDetails> colorVariant, List<FeatureDetails> features, List<UnboxingDetails> unboxing,
			List<ProductVariantDetails> original, Integer productWarranty, byte[] image, double interestRate,
			Boolean exclusive, String accessoriesIncluded, Boolean enabled, String imageToShow,
			List<SpecSection> specList) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.manufacturerID = manufacturerID;
		this.categoryID = categoryID;
		this.article = article;
		this.cameraShots = cameraShots;
		this.colorVariant = colorVariant;
		this.features = features;
		this.unboxing = unboxing;
		this.original = original;
		this.productWarranty = productWarranty;
		this.image = image;
		this.interestRate = interestRate;
		this.exclusive = exclusive;
		this.accessoriesIncluded = accessoriesIncluded;
		this.enabled = enabled;
		this.imageToShow = imageToShow;
		this.specList = specList;
	}

	public String getProductID() {
		return productID;
	}

	public String getProductName() {
		return productName;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getManufacturerID() {
		return manufacturerID;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public ArticleDetails getArticle() {
		return article;
	}

	public List<CameraShotsDetails> getCameraShots() {
		return cameraShots;
	}

	public List<ColorVariantDetails> getColorVariant() {
		return colorVariant;
	}

	public List<FeatureDetails> getFeatures() {
		return features;
	}

	public List<UnboxingDetails> getUnboxing() {
		return unboxing;
	}

	public List<ProductVariantDetails> getOriginal() {
		return original;
	}

	public Integer getProductWarranty() {
		return productWarranty;
	}

	public byte[] getImage() {
		return image;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public Boolean getExclusive() {
		return exclusive;
	}

	public String getAccessoriesIncluded() {
		return accessoriesIncluded;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public String getImageToShow() {
		return imageToShow;
	}

	public List<SpecSection> getSpecList() {
		return specList;
	}

	
}
