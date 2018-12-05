package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Dao.SupplierDao;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Product;
import com.niit.CosmeticsBackend.Model.Supplier;

public class ProductTest {
	public static void main (String args[])
	{
	    AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	    ctx.scan("com.niit.*");
	    ctx.refresh();
	    Product product=(Product)ctx.getBean("product");
	    ProductDao productDao=(ProductDao)ctx.getBean("productDao");
	    Category cat=(Category)ctx.getBean("category");
	    CategoryDao catDao=(CategoryDao)ctx.getBean("categoryDao");
	    Supplier sup=(Supplier)ctx.getBean("supplier");
	    SupplierDao supDao=(SupplierDao)ctx.getBean("supplierDao");
	    product.setProductId("p101");
	    product.setProductName("product1");
	    product.setProductQuantity("00");
	    product.setProductDescription("good");
	    product.setProductPrice(100.0);
	   cat=catDao.getCategory("c102");
	    product.setCategory(cat);
	    sup=supDao.getsupplier("s102");
	    product.setSupplier(sup);
	    if(productDao.saveorupdateproduct(product)==true)
	    {
	    	System.out.println("product saved");
	    }
	    else
	    {
	    	System.out.println("product not saved");
	    }
	    product.setProductId("p102");
	    product.setProductName("product2");
	    product.setProductQuantity("00");
	    product.setProductDescription("good");
	    product.setProductPrice(100.0);
	    cat=catDao.getCategory("c103");
	    product.setCategory(cat);
	   
	    
	    if (productDao.saveorupdateproduct(product)==true)
	    {
	    	System.out.print("product saved");
	    }
	    else
	    {
	    	System.out.print("product not saved");
	    	
	    }
	    
	    
	    product.setProductId("p103");
	    product.setProductName("product3");
	    product.setProductQuantity("00");
	    product.setProductDescription("good");
	    product.setProductPrice(100.87);
	    cat=catDao.getCategory("c102");
	    product.setCategory(cat);
	    if(productDao.saveorupdateproduct(product)==true)
	    {
	    	System.out.print("product is saved");
	    }
	    else
	    {
	    	System.out.print("product is not saved");
	    }
	    product=productDao.getproduct("p101");
	    if(productDao.deleteproduct(product)==true)
	    	{
	    	System.out.println("product deleted");
	    	}
	    else
	    {
	    	System.out.println("product not deleted");
	    }
	    
	    product=productDao.getproduct("p102");
	    if(product==null)
	    {
	    	System.out.println("product is not found");
	    }
	    else
	    {
	    	System.out.println(product.getProductId());
	    	System.out.println(product.getProductName());
	    }
	    
	    List<Product> productlist=productDao.list();
	    if(productlist==null||productlist.isEmpty())
	    {
	    	System.out.println("product is empty");
	    }
	    else 
	    {
	    	for(Product p:productlist)
	    	{
	    		System.out.println(p.getProductId());
	    		System.out.println(p.getProductName());
	    	}
	    }
	    
	    	}
	    }
	    
