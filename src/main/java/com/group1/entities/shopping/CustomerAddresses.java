package com.group1.entities.shopping;

import java.io.Serializable;

import com.group1.entities.store.City;
import com.group1.entities.store.District;
import com.group1.entities.store.Ward;

public class CustomerAddresses implements Serializable{
	
	private Integer id;
	
	private Customer customerIdentifier;

	private Integer customerId;

	private Integer address;

	private City cityIdentifier;

	private Integer cityId;

	private District districtIdentifier;

	private Integer districtId;

	private Ward wardIdentifier;

	private Integer wardId;

	public CustomerAddresses() {
		
	}

	public CustomerAddresses(Integer id, Customer customerIdentifier, Integer customerId, Integer address,
			City cityIdentifier, Integer cityId, District districtIdentifier, Integer districtId, Ward wardIdentifier,
			Integer wardId) {
		super();
		this.id = id;
		this.customerIdentifier = customerIdentifier;
		this.customerId = customerId;
		this.address = address;
		this.cityIdentifier = cityIdentifier;
		this.cityId = cityId;
		this.districtIdentifier = districtIdentifier;
		this.districtId = districtId;
		this.wardIdentifier = wardIdentifier;
		this.wardId = wardId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(Customer customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getAddress() {
		return address;
	}

	public void setAddress(Integer address) {
		this.address = address;
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

	@Override
	public String toString() {
		return "id=" + id + "\n       customerIdentifier=" + customerIdentifier + "\n       customerId=" + customerId
				+ "\n       address=" + address + "\n       cityIdentifier=" + cityIdentifier + "\n       cityId="
				+ cityId + "\n       districtIdentifier=" + districtIdentifier + "\n       districtId=" + districtId
				+ "\n       wardIdentifier=" + wardIdentifier + "\n       wardId=" + wardId;
	}

	

}
