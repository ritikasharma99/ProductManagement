package com.category.product.Product;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Category 
{
	//Variable containing category name
	private String Category;

	//Getter and Setter of Category
	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}
	
}
