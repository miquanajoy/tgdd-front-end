package com.group1.entities.product;

import java.io.Serializable;
import java.util.List;

import com.group1.dto.SpecSection;

public class ProductSpecification implements Serializable{

	private Integer id;

	private Product productSpecificationIdentifier;

	private String productID;

	private String productSpecifications;

	public ProductSpecification() {
	}

	public ProductSpecification(Integer id, Product productSpecificationIdentifier, String productID,
			String productSpecifications) {
		super();
		this.id = id;
		this.productSpecificationIdentifier = productSpecificationIdentifier;
		this.productID = productID;
		this.productSpecifications = productSpecifications;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductSpecificationIdentifier() {
		return productSpecificationIdentifier;
	}

	public void setProductSpecificationIdentifier(Product productSpecificationIdentifier) {
		this.productSpecificationIdentifier = productSpecificationIdentifier;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductSpecifications() {
		return productSpecifications;
	}

	public void setProductSpecifications(String productSpecifications) {
		this.productSpecifications = productSpecifications;
	}

	@Override
	public String toString() {
		return "id=" + id + "\n       productID=" + productID + "\n       productSpecifications="
				+ productSpecifications ;
	}
	
}
