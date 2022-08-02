package com.group1.entities.product;

public class ProductTechSpecs {

	private Integer id;

	private Category categoryIdentifier;

	private Integer categoryID;

	private String specName;

	private String section;

	public ProductTechSpecs() {
		
	}

	public ProductTechSpecs(Integer id, Integer categoryID, String specName, String section) {
		super();
		this.id = id;
		this.categoryID = categoryID;
		this.specName = specName;
		this.section = section;
	}
	
	public ProductTechSpecs(Integer id, Category categoryIdentifier, Integer categoryID, String specName,
			String section) {
		super();
		this.id = id;
		this.categoryIdentifier = categoryIdentifier;
		this.categoryID = categoryID;
		this.specName = specName;
		this.section = section;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategoryIdentifier() {
		return categoryIdentifier;
	}

	public void setCategoryIdentifier(Category categoryIdentifier) {
		this.categoryIdentifier = categoryIdentifier;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "id=" + id + "\n       categoryID=" + categoryID + "\n       specName=" + specName + "\n       section="
				+ section;
	}

}
