package com.group1.entities.shopping;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

public class PromoteCode implements Serializable {

	private Integer promoteCodeID;

	private Set<ShoppingBill> billsWithPromoteID;

	private String promoteCodeName;

	private String promoteCodeDescription;

	private Integer discountPercent;

	private Integer discountMaxAmount;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime startDateInput;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime endDateInput;

	private Boolean enabled;

	public PromoteCode() {
	}
	
	public PromoteCode(Integer promoteCodeID, String promoteCodeName, String promoteCodeDescription,
			Integer discountPercent, Integer discountMaxAmount, LocalDateTime startDate, LocalDateTime endDate,
			Boolean enabled) {
		super();
		this.promoteCodeID = promoteCodeID;
		this.promoteCodeName = promoteCodeName;
		this.promoteCodeDescription = promoteCodeDescription;
		this.discountPercent = discountPercent;
		this.discountMaxAmount = discountMaxAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.enabled = enabled;
	}

	public PromoteCode(Integer promoteCodeID, Set<ShoppingBill> billsWithPromoteID, String promoteCodeName,
			String promoteCodeDescription, Integer discountPercent, Integer discountMaxAmount, LocalDateTime startDate,
			LocalDateTime endDate, LocalDateTime startDateInput, LocalDateTime endDateInput, Boolean enabled) {
		super();
		this.promoteCodeID = promoteCodeID;
		this.billsWithPromoteID = billsWithPromoteID;
		this.promoteCodeName = promoteCodeName;
		this.promoteCodeDescription = promoteCodeDescription;
		this.discountPercent = discountPercent;
		this.discountMaxAmount = discountMaxAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startDateInput = startDateInput;
		this.endDateInput = endDateInput;
		this.enabled = enabled;
	}

	public Integer getPromoteCodeID() {
		return promoteCodeID;
	}

	public void setPromoteCodeID(Integer promoteCodeID) {
		this.promoteCodeID = promoteCodeID;
	}

	public Set<ShoppingBill> getBillsWithPromoteID() {
		return billsWithPromoteID;
	}

	public void setBillsWithPromoteID(Set<ShoppingBill> billsWithPromoteID) {
		this.billsWithPromoteID = billsWithPromoteID;
	}

	public String getPromoteCodeName() {
		return promoteCodeName;
	}

	public void setPromoteCodeName(String promoteCodeName) {
		this.promoteCodeName = promoteCodeName;
	}

	public String getPromoteCodeDescription() {
		return promoteCodeDescription;
	}

	public void setPromoteCodeDescription(String promoteCodeDescription) {
		this.promoteCodeDescription = promoteCodeDescription;
	}

	public Integer getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Integer getDiscountMaxAmount() {
		return discountMaxAmount;
	}

	public void setDiscountMaxAmount(Integer discountMaxAmount) {
		this.discountMaxAmount = discountMaxAmount;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public LocalDateTime getStartDateInput() {
		return startDateInput;
	}

	public void setStartDateInput(LocalDateTime startDateInput) {
		this.startDateInput = startDateInput;
	}

	public LocalDateTime getEndDateInput() {
		return endDateInput;
	}

	public void setEndDateInput(LocalDateTime endDateInput) {
		this.endDateInput = endDateInput;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "promoteCodeID=" + promoteCodeID + "\n       billsWithPromoteID=" + billsWithPromoteID
				+ "\n       promoteCodeName=" + promoteCodeName + "\n       promoteCodeDescription="
				+ promoteCodeDescription + "\n       discountPercent=" + discountPercent + "\n       discountMaxAmount="
				+ discountMaxAmount + "\n       startDate=" + startDate + "\n       endDate=" + endDate
				+ "\n       startDateInput=" + startDateInput + "\n       endDateInput=" + endDateInput
				+ "\n       enabled=" + enabled;
	}

	
}