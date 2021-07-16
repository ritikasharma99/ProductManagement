package com.category.product.Product;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("details")
public class Resources //Resources required for Category and Product Entities
{
	DAO dao = new DAO();
	
	@GET
	@Path("product")
	@Produces(MediaType.APPLICATION_XML)
	public List<Product> getProducts()
	{
		return dao.getPs();
	}
	
	@GET
	@Path("product/{category}")
	@Produces(MediaType.APPLICATION_XML)
	public Product getProduct(@PathParam("category") String category)
	{
		
		return dao.getP(category);
	}
	
	@GET
	@Path("category")
	@Produces(MediaType.APPLICATION_XML)
	public List<Category> getCategories()
	{
		return dao.getCs();
	}
	
		
	@POST
	@Path("product")
	@Consumes(MediaType.APPLICATION_XML)
	public Product addProduct(Product p)
	{
		System.out.println(p);
		dao.addP(p);
		return p;
	}
	
	
	@POST
	@Path("category")
	@Consumes(MediaType.APPLICATION_XML)
	public Category addCategory(Category c)
	{
		dao.addC(c);
		return c;
	}
	

	@PUT
	@Path("product")
	@Consumes(MediaType.APPLICATION_XML)
	public Product updateProduct(Product p)
	{
		System.out.println(p);
		dao.update(p);
		return p;
	}
	
}
