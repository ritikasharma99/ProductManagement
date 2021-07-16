package com.category.product.Product;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class DAO 
{
	Connection con=null;
	public DAO()
	{
		//Making Connection with MySQL Database
		String url = "jdbc:mysql://localhost:3306/pm?user=root&password=ritika";
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	con = DriverManager.getConnection(url);
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	   		
	}
	
//Method to retrieve multiple categories from database
public List<Category> getCs() 
{
	List<Category> cat = new ArrayList<>();
	String sql = "select * from CategoryDetails";
	try{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			Category c = new Category();
			c.setCategory(rs.getString(1));
			cat.add(c);
		}
	}
	catch(Exception e)
    {
    	System.out.println(e);
    }
	
	return cat;
	}

//Method to get details of all products
	public List<Product> getPs()
	{
		List<Product> products = new ArrayList<>();
		String sql = "select * from ProductDetails";
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Product pro = new Product();
				pro.setCategory(rs.getString(1));
				pro.setName(rs.getString(2));
				pro.setPrice(3);
				products.add(pro);
			}
		}
		catch(Exception e)
	    {
	    	System.out.println(e);
	    }
		
		return products;
	}
	
//Method to get details of products for specified category	
	public Product getP(String category)
	{
		String sql = "select * from ProductDetails where Category="+category;
		Product pro = new Product();
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				pro.setCategory(rs.getString(1));
				pro.setName(rs.getString(2));
				pro.setPrice(3);
			}
		}
		catch(Exception e)
	    {
	    	System.out.println(e);
	    }
		
		return pro;
	}
	
//Method to add new product	
	public void addP(Product p) 
	{
		String sql = "insert into ProductDetails values(?,?,?)";
		try{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, p.getCategory());
			st.setString(2, p.getName());
			st.setInt(3, p.getPrice());
			st.executeUpdate();
		}
		catch(Exception e)
	    {
	    	System.out.println(e);
	    }
		
	}

//Method to add new category	
	public void addC(Category c) 
	{
		String sql = "insert into CategoryDetails value(?)";
		try{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, c.getCategory());
			st.executeUpdate();
		}
		catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	}
	
//Method to update product details
	public void update(Product p) 
	{
		String sql = "update ProductDetails set Price=? where Category=? and Name=?";
		try{
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, p.getCategory());
			st.setString(2, p.getName());
			st.setInt(3, p.getPrice());
			st.executeUpdate();
		}
		catch(Exception e)
	    {
	    	System.out.println(e);
	    }
		
	}
	
}
