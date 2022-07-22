package com.group1.entities.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.group1.dto.ColorVariantUpdateDTO;
import com.group1.dto.SpecSection;
import com.group1.entities.shopping.BillDetail;

public class Product implements Serializable{

	private String productID;
	
	private String productName;
	
	private Integer price;
	
	private Manufacturer manufacturer;
	
	private Integer manufacturerID;
	
	private Category category;
	
	private Integer categoryID;
	
	private Set<BillDetail> productInBills;

	private ProductDiscount discount;

	private ProductArticle article;

	private Set<ProductCameraShot> cameraShots;

	private Set<ProductColorVariant> colorVariant;

	private Set<ProductFeature> features;

	private ProductSpecification specifications;

	private Set<ProductUnboxingReview> unboxing;

	private ProductVariant variant;

	private Set<ProductVariant> original;

	private Integer productWarranty;

	private byte[] image;

	private String imageType;

	private double interestRate;

	private Boolean exclusive;

	private String accessoriesIncluded;

	private Boolean enabled;

	private List<ProductColorVariant> colorVariantInputList;

	private String imageToShow;
	
	private List<ColorVariantUpdateDTO> colorVarUpdateList;

	public List<SpecSection> specList;
	
	public Product() {
		
	}
	
	public Product(String productID, String productName, Integer price, Integer manufacturerID, 
			Integer categoryID, Integer productWarranty, byte[] image, String imageType,
			double interestRate, Boolean exclusive, String accessoriesIncluded, Boolean enabled) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.manufacturerID = manufacturerID;
		this.categoryID = categoryID;
		this.productWarranty = productWarranty;
		this.image = image;
		this.imageType = imageType ;
		this.interestRate = interestRate;
		this.exclusive = exclusive;
		this.accessoriesIncluded = accessoriesIncluded;
		this.enabled = enabled;
		this.imageToShow = imageToShow;
	}

	public Product(String productID, String productName, Integer price, Manufacturer manufacturer,
			Integer manufacturerID, Category category, Integer categoryID, Set<BillDetail> productInBills , ProductDiscount discount,
			ProductArticle article, Set<ProductCameraShot> cameraShots, Set<ProductColorVariant> colorVariant,
			Set<ProductFeature> features, ProductSpecification specifications, Set<ProductUnboxingReview> unboxing,
			ProductVariant variant, Set<ProductVariant> original, Integer productWarranty, byte[] image, String imageType,
			double interestRate, Boolean exclusive, String accessoriesIncluded, Boolean enabled,
			List<ProductColorVariant> colorVariantInputList, String imageToShow, List<ColorVariantUpdateDTO> colorVarUpdateList
			, List<SpecSection> specList) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.manufacturer = manufacturer;
		this.manufacturerID = manufacturerID;
		this.category = category;
		this.categoryID = categoryID;
		this.productInBills =productInBills;
		this.discount = discount;
		this.article = article;
		this.cameraShots = cameraShots;
		this.colorVariant = colorVariant;
		this.features = features;
		this.specifications = specifications;
		this.unboxing = unboxing;
		this.variant = variant;
		this.original = original;
		this.productWarranty = productWarranty;
		this.image = image;
		this.imageType = imageType ;
		this.interestRate = interestRate;
		this.exclusive = exclusive;
		this.accessoriesIncluded = accessoriesIncluded;
		this.enabled = enabled;
		this.colorVariantInputList = colorVariantInputList;
		this.imageToShow = imageToShow;
		this.colorVarUpdateList = colorVarUpdateList;
		this.specList = specList;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(Integer manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public Set<BillDetail> getProductInBills() {
		return productInBills;
	}

	public void setProductInBills(Set<BillDetail> productInBills) {
		this.productInBills = productInBills;
	}

	public ProductDiscount getDiscount() {
		return discount;
	}

	public void setDiscount(ProductDiscount discount) {
		this.discount = discount;
	}

	public ProductArticle getArticle() {
		return article;
	}

	public void setArticle(ProductArticle article) {
		this.article = article;
	}

	public Set<ProductCameraShot> getCameraShots() {
		return cameraShots;
	}

	public void setCameraShots(Set<ProductCameraShot> cameraShots) {
		this.cameraShots = cameraShots;
	}

	public Set<ProductColorVariant> getColorVariant() {
		return colorVariant;
	}

	public void setColorVariant(Set<ProductColorVariant> colorVariant) {
		this.colorVariant = colorVariant;
	}

	public Set<ProductFeature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<ProductFeature> features) {
		this.features = features;
	}

	public ProductSpecification getSpecifications() {
		return specifications;
	}

	public void setSpecifications(ProductSpecification specifications) {
		this.specifications = specifications;
	}

	public Set<ProductUnboxingReview> getUnboxing() {
		return unboxing;
	}

	public void setUnboxing(Set<ProductUnboxingReview> unboxing) {
		this.unboxing = unboxing;
	}

	public ProductVariant getVariant() {
		return variant;
	}

	public void setVariant(ProductVariant variant) {
		this.variant = variant;
	}

	public Set<ProductVariant> getOriginal() {
		return original;
	}

	public void setOriginal(Set<ProductVariant> original) {
		this.original = original;
	}

	public Integer getProductWarranty() {
		return productWarranty;
	}

	public void setProductWarranty(Integer productWarranty) {
		this.productWarranty = productWarranty;
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

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Boolean getExclusive() {
		return exclusive;
	}

	public void setExclusive(Boolean exclusive) {
		this.exclusive = exclusive;
	}

	public String getAccessoriesIncluded() {
		return accessoriesIncluded;
	}

	public void setAccessoriesIncluded(String accessoriesIncluded) {
		this.accessoriesIncluded = accessoriesIncluded;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<ProductColorVariant> getColorVariantInputList() {
		return colorVariantInputList;
	}

	public void setColorVariantInputList(List<ProductColorVariant> colorVariantInputList) {
		this.colorVariantInputList = colorVariantInputList;
	}

	public String getImageToShow() {
		return imageToShow;
	}

	public void setImageToShow(String imageToShow) {
		this.imageToShow = imageToShow;
	}
	
	public List<ColorVariantUpdateDTO> getColorVarUpdateList() {
		return colorVarUpdateList;
	}

	public void setColorVarUpdateList(List<ColorVariantUpdateDTO> colorVarUpdateList) {
		this.colorVarUpdateList = colorVarUpdateList;
	}

	public List<SpecSection> getSpecList() {
		return specList;
	}

	public void setSpecList(List<SpecSection> specList) {
		this.specList = specList;
	}
	
	public String toString1() {
		return "productID=" + productID + "\n       productName=" + productName + "\n       price=" + price
				+ "\n       manufacturerID=" + manufacturerID + "\n       categoryID=" + categoryID
				+ "\n       productWarranty=" + productWarranty + "\n       imageType=" + imageType
				+ "\n       interestRate=" + interestRate + "\n       exclusive=" + exclusive
				+ "\n       accessoriesIncluded=" + accessoriesIncluded + "\n       enabled=" + enabled
				+ "\n       specList=" + specList;
	}

	@Override
	public String toString() {
		return "productID=" + productID + "\n       productName=" + productName + "\n       price=" + price
				+ "\n       manufacturer=" + manufacturer + "\n       manufacturerID=" + manufacturerID
				+ "\n       category=" + category + "\n       categoryID=" + categoryID + "\n       discount="
				+ discount + "\n       article=" + article + "\n       cameraShots=" + cameraShots
				+ "\n       colorVariant=" + colorVariant + "\n       features=" + features + "\n       specifications="
				+ specifications + "\n       unboxing=" + unboxing + "\n       variant=" + variant
				+ "\n       original=" + original + "\n       productWarranty=" + productWarranty
				+ "\n       imageType=" + imageType + "\n       interestRate=" + interestRate + "\n       exclusive="
				+ exclusive + "\n       accessoriesIncluded=" + accessoriesIncluded + "\n       enabled=" + enabled
				+ "\n       colorVariantInputList=" + colorVariantInputList + "\n       colorVarUpdateList="
				+ colorVarUpdateList + "\n       specList=" + specList;
	}

	
}