package com.group1.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

public class CategoryList implements Serializable{
	
	private Integer categoryID;

	private Boolean isParent;

	private Integer level;

	private byte[] icon;

	private String categoryName;

	private Integer parentID;

	private Boolean enabled;
	
	public CategoryList() {
	}

	public CategoryList(Integer categoryID, Boolean isParent, Integer level, byte[] icon, String categoryName,
			Integer parentID, Boolean enabled) {
		this.categoryID = categoryID;
		this.isParent = isParent;
		this.level = level;
		this.icon = icon;
		this.categoryName = categoryName;
		this.parentID = parentID;
		this.enabled = enabled;
	}



	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
	

	@Override
	public String toString() {
		return "categoryID=" + categoryID + "\n       isParent=" + isParent + "\n       level=" + level
				+ "\n       icon=" + Arrays.toString(icon) + "\n       categoryName=" + categoryName
				+ "\n       parentID=" + parentID + "\n       enabled=" + enabled;
	}

}
