package com.group1.dto.CustomerViewProductDetails;

public class ArticleDetails {
	
	private String articleUrl;
	
	public ArticleDetails() {
		
	}

	public ArticleDetails(String articleUrl) {
		super();
		this.articleUrl = articleUrl;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	@Override
	public String toString() {
		return "articleUrl=" + articleUrl;
	}

	
}
