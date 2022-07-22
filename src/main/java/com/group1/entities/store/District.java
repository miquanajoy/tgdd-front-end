package com.group1.entities.store;

import java.io.Serializable;
import java.util.Set;

import com.group1.entities.shopping.CustomerAddresses;

public class District implements Serializable {

	private Integer districtID;

	private Set<Store> storeWithDistrictID;

	private Set<CustomerAddresses> customerWithDistrictID;

	private Set<Ward> wardsWithDistrictID;

	private String districtName;

	private City cityIdentity;

	private Integer cityID;
	
	public District() {
	}

	public District(Integer districtID, Set<Store> storeWithDistrictID, Set<CustomerAddresses> customerWithDistrictID,
			Set<Ward> wardsWithDistrictID, String districtName, City cityIdentity, Integer cityID) {
		super();
		this.districtID = districtID;
		this.storeWithDistrictID = storeWithDistrictID;
		this.customerWithDistrictID = customerWithDistrictID;
		this.wardsWithDistrictID = wardsWithDistrictID;
		this.districtName = districtName;
		this.cityIdentity = cityIdentity;
		this.cityID = cityID;
	}

	public Integer getDistrictID() {
		return districtID;
	}

	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}

	public Set<Store> getStoreWithDistrictID() {
		return storeWithDistrictID;
	}

	public void setStoreWithDistrictID(Set<Store> storeWithDistrictID) {
		this.storeWithDistrictID = storeWithDistrictID;
	}

	public Set<CustomerAddresses> getCustomerWithDistrictID() {
		return customerWithDistrictID;
	}

	public void setCustomerWithDistrictID(Set<CustomerAddresses> customerWithDistrictID) {
		this.customerWithDistrictID = customerWithDistrictID;
	}

	public Set<Ward> getWardsWithDistrictID() {
		return wardsWithDistrictID;
	}

	public void setWardsWithDistrictID(Set<Ward> wardsWithDistrictID) {
		this.wardsWithDistrictID = wardsWithDistrictID;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public City getCityIdentity() {
		return cityIdentity;
	}

	public void setCityIdentity(City cityIdentity) {
		this.cityIdentity = cityIdentity;
	}

	public Integer getCityID() {
		return cityID;
	}

	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}

	@Override
	public String toString() {
		return "districtID=" + districtID + "\n       storeWithDistrictID=" + storeWithDistrictID
				+ "\n       customerWithDistrictID=" + customerWithDistrictID + "\n       wardsWithDistrictID="
				+ wardsWithDistrictID + "\n       districtName=" + districtName + "\n       cityIdentity="
				+ cityIdentity + "\n       cityID=" + cityID;
	}


}
