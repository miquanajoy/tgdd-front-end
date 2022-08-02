package com.group1.entities.store;

import java.io.Serializable;
import java.util.Set;

import com.group1.entities.shopping.CustomerAddresses;

public class Ward implements Serializable {

	private Integer wardId;

	private Set<Store> storeWithWardID;

	private Set<CustomerAddresses> customersWithWardID;

	private String wardName;

	private District districtIdentity;

	private Integer districtID;

	public Ward() {
	}

	public Ward(Integer wardId, Set<Store> storeWithWardID, Set<CustomerAddresses> customersWithWardID, String wardName,
			District districtIdentity, Integer districtID) {
		super();
		this.wardId = wardId;
		this.storeWithWardID = storeWithWardID;
		this.customersWithWardID = customersWithWardID;
		this.wardName = wardName;
		this.districtIdentity = districtIdentity;
		this.districtID = districtID;
	}

	public Integer getWardId() {
		return wardId;
	}

	public void setWardId(Integer wardId) {
		this.wardId = wardId;
	}

	public Set<Store> getStoreWithWardID() {
		return storeWithWardID;
	}

	public void setStoreWithWardID(Set<Store> storeWithWardID) {
		this.storeWithWardID = storeWithWardID;
	}

	public Set<CustomerAddresses> getCustomersWithWardID() {
		return customersWithWardID;
	}

	public void setCustomersWithWardID(Set<CustomerAddresses> customersWithWardID) {
		this.customersWithWardID = customersWithWardID;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public District getDistrictIdentity() {
		return districtIdentity;
	}

	public void setDistrictIdentity(District districtIdentity) {
		this.districtIdentity = districtIdentity;
	}

	public Integer getDistrictID() {
		return districtID;
	}

	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}

	@Override
	public String toString() {
		return "wardId=" + wardId + "\n       storeWithWardID=" + storeWithWardID + "\n       customersWithWardID="
				+ customersWithWardID + "\n       wardName=" + wardName + "\n       districtIdentity="
				+ districtIdentity + "\n       districtID=" + districtID;
	}

	

}
