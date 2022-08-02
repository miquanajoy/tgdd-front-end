package com.group1.entities.store;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

public class Store implements Serializable {

	private Integer storeId;

	private String storeName;

	private String address;

	private String openingHours;

	private byte[] image;

	private City cityIdentifier;

	private Integer cityId;

	private District districtIdentifier;

	private Integer districtId;

	private Ward wardIdentifier;

	private Integer wardId;

	private Set<StoreProductInStock> productsInStore;

	private Boolean enabled;

	private String toShowImage;
	
	public Store() {
	}

	public Store(Integer storeId, String storeName, String address, String openingHours, byte[] image,
			City cityIdentifier, Integer cityId, District districtIdentifier, Integer districtId, Ward wardIdentifier,
			Integer wardId, Set<StoreProductInStock> productsInStore, Boolean enabled, String toShowImage) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.address = address;
		this.openingHours = openingHours;
		this.image = image;
		this.cityIdentifier = cityIdentifier;
		this.cityId = cityId;
		this.districtIdentifier = districtIdentifier;
		this.districtId = districtId;
		this.wardIdentifier = wardIdentifier;
		this.wardId = wardId;
		this.productsInStore = productsInStore;
		this.enabled = enabled;
		this.toShowImage = toShowImage;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public City getCityIdentifier() {
		return cityIdentifier;
	}

	public void setCityIdentifier(City cityIdentifier) {
		this.cityIdentifier = cityIdentifier;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public District getDistrictIdentifier() {
		return districtIdentifier;
	}

	public void setDistrictIdentifier(District districtIdentifier) {
		this.districtIdentifier = districtIdentifier;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Ward getWardIdentifier() {
		return wardIdentifier;
	}

	public void setWardIdentifier(Ward wardIdentifier) {
		this.wardIdentifier = wardIdentifier;
	}

	public Integer getWardId() {
		return wardId;
	}

	public void setWardId(Integer wardId) {
		this.wardId = wardId;
	}

	public Set<StoreProductInStock> getProductsInStore() {
		return productsInStore;
	}

	public void setProductsInStore(Set<StoreProductInStock> productsInStore) {
		this.productsInStore = productsInStore;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getToShowImage() {
		return toShowImage;
	}

	public void setToShowImage(String toShowImage) {
		this.toShowImage = toShowImage;
	}

	@Override
	public String toString() {
		return "storeId=" + storeId + "\n       storeName=" + storeName + "\n       address=" + address
				+ "\n       openingHours=" + openingHours + "\n       image=" + Arrays.toString(image)
				+ "\n       cityIdentifier=" + cityIdentifier + "\n       cityId=" + cityId
				+ "\n       districtIdentifier=" + districtIdentifier + "\n       districtId=" + districtId
				+ "\n       wardIdentifier=" + wardIdentifier + "\n       wardId=" + wardId
				+ "\n       productsInStore=" + productsInStore + "\n       enabled=" + enabled
				+ "\n       toShowImage=" + toShowImage;
	}

	

}
