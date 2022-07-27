package com.group1.entities.product;

import java.io.Serializable;

public class ProductArticle implements Serializable{

	private Integer articleID;

	private Product productArticleIdentifier;

	private String productID;

	private String articleUrl;

	public ProductArticle() {
	}

	public ProductArticle(Integer articleID, Product productArticleIdentifier, String productID, String articleUrl) {
		super();
		this.articleID = articleID;
		this.productArticleIdentifier = productArticleIdentifier;
		this.productID = productID;
		this.articleUrl = articleUrl;
	}

	public Integer getArticleID() {
		return articleID;
	}

	public void setArticleID(Integer articleID) {
		this.articleID = articleID;
	}

	public Product getProductArticleIdentifier() {
		return productArticleIdentifier;
	}

	public void setProductArticleIdentifier(Product productArticleIdentifier) {
		this.productArticleIdentifier = productArticleIdentifier;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	@Override
	public String toString() {
		return "ProductArticle:\n\tarticleID=" + articleID + " \n\tproductID=" + productID + " \n\tarticleUrl="
				+ articleUrl;
	}

	
}
