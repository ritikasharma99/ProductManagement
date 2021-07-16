package com.category.product.Product;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product 
{
	//Variables to contain product details
	private String category;
	private String name;
    private int price;
    
    //Getters and Setters for variables containing product details
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}	
	
}
