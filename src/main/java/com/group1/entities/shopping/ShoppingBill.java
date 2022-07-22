package com.group1.entities.shopping;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

public class ShoppingBill implements Serializable{

	private Integer billId;

	private Customer customerIdentifier;

	private Set<BillDetail> billItems;

	private Integer customerID;

	private LocalDateTime timeCreated;

	private Integer promoteCodeID;

	private PromoteCode promoteCodeIdentifier;

	private String deliveryAddress;

	private String deliveryType;

	private String otherRequirements;

	private String replacingReceiverName;

	private String replacingReceiverGender;

	private String replacingReceiverPhoneNumber;

	private Boolean status;
	public ShoppingBill() {
	}

	public ShoppingBill(Integer billId, Customer customerIdentifier, Set<BillDetail> billItems, Integer customerID,
			LocalDateTime timeCreated, Integer promoteCodeID, PromoteCode promoteCodeIdentifier, String deliveryAddress,
			String deliveryType, String otherRequirements, String replacingReceiverName, String replacingReceiverGender,
			String replacingReceiverPhoneNumber, Boolean status) {
		super();
		this.billId = billId;
		this.customerIdentifier = customerIdentifier;
		this.billItems = billItems;
		this.customerID = customerID;
		this.timeCreated = timeCreated;
		this.promoteCodeID = promoteCodeID;
		this.promoteCodeIdentifier = promoteCodeIdentifier;
		this.deliveryAddress = deliveryAddress;
		this.deliveryType = deliveryType;
		this.otherRequirements = otherRequirements;
		this.replacingReceiverName = replacingReceiverName;
		this.replacingReceiverGender = replacingReceiverGender;
		this.replacingReceiverPhoneNumber = replacingReceiverPhoneNumber;
		this.status =status;
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public Customer getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(Customer customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public Set<BillDetail> getBillItems() {
		return billItems;
	}

	public void setBillItems(Set<BillDetail> billItems) {
		this.billItems = billItems;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public LocalDateTime getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(LocalDateTime timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Integer getPromoteCodeID() {
		return promoteCodeID;
	}

	public void setPromoteCodeID(Integer promoteCodeID) {
		this.promoteCodeID = promoteCodeID;
	}

	public PromoteCode getPromoteCodeIdentifier() {
		return promoteCodeIdentifier;
	}

	public void setPromoteCodeIdentifier(PromoteCode promoteCodeIdentifier) {
		this.promoteCodeIdentifier = promoteCodeIdentifier;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getOtherRequirements() {
		return otherRequirements;
	}

	public void setOtherRequirements(String otherRequirements) {
		this.otherRequirements = otherRequirements;
	}

	public String getReplacingReceiverName() {
		return replacingReceiverName;
	}

	public void setReplacingReceiverName(String replacingReceiverName) {
		this.replacingReceiverName = replacingReceiverName;
	}

	public String getReplacingReceiverGender() {
		return replacingReceiverGender;
	}

	public void setReplacingReceiverGender(String replacingReceiverGender) {
		this.replacingReceiverGender = replacingReceiverGender;
	}

	public String getReplacingReceiverPhoneNumber() {
		return replacingReceiverPhoneNumber;
	}

	public void setReplacingReceiverPhoneNumber(String replacingReceiverPhoneNumber) {
		this.replacingReceiverPhoneNumber = replacingReceiverPhoneNumber;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "billId=" + billId + "\n       customerIdentifier=" + customerIdentifier + "\n       billItems="
				+ billItems + "\n       customerID=" + customerID + "\n       timeCreated=" + timeCreated
				+ "\n       promoteCodeID=" + promoteCodeID + "\n       promoteCodeIdentifier=" + promoteCodeIdentifier
				+ "\n       deliveryAddress=" + deliveryAddress + "\n       deliveryType=" + deliveryType
				+ "\n       otherRequirements=" + otherRequirements + "\n       replacingReceiverName="
				+ replacingReceiverName + "\n       replacingReceiverGender=" + replacingReceiverGender
				+ "\n       replacingReceiverPhoneNumber=" + replacingReceiverPhoneNumber + "\n       status=" + status;
	}
	
	
}
