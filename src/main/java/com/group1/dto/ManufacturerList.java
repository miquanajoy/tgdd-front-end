package com.group1.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

//fixed

public class ManufacturerList implements Serializable {

	private Integer manufacturerID;

	private String manufacturerName;

	private byte[] icon;

	private Integer categoryID;

	private Boolean enabled;

	public ManufacturerList() {
	}

	public ManufacturerList(Integer manufacturerID, String manufacturerName, byte[] icon, Integer categoryID,
			Boolean enabled) {
		this.manufacturerID = manufacturerID;
		this.manufacturerName = manufacturerName;
		this.icon = icon;
		this.categoryID = categoryID;
		this.enabled = enabled;
	}

	public Integer getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(Integer manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "manufacturerID=" + manufacturerID + "\n       manufacturerName=" + manufacturerName + "\n       icon="
				+ Arrays.toString(icon) + "\n       categoryID=" + categoryID + "\n       enabled=" + enabled;
	}

}
