package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.OrderDao;
import com.niit.CosmeticsBackend.Dao.OrderItemsDao;
import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Model.Order;
import com.niit.CosmeticsBackend.Model.OrderItems;
import com.niit.CosmeticsBackend.Model.Product;

public class OrderItemsTest {
	
	public static void main (String args[])

	{
	    AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	    ctx.scan("com.niit.*");
	    ctx.refresh();
	    OrderItems ortm=(OrderItems)ctx.getBean("orderItems");
	    OrderItemsDao ortmDao=(OrderItemsDao)ctx.getBean("orderItemsDao");
	    Product product=(Product)ctx.getBean("product");
	    ProductDao productDao=(ProductDao)ctx.getBean("productDao");
	    Order or=(Order)ctx.getBean("order");
	    OrderDao orDao=(OrderDao)ctx.getBean("orderDao");
	    ortm.setOrderItemId("or101");
	    product=productDao.getproduct("p101");
	    or=orDao.getOrder("o101");
	    ortm.setOrder(or);

	 
	   
	    if(ortmDao.saveorupdateOrderItems(ortm)==true)
	    {
	    	System.out.println("orderItems saved");
	    }
	    else
	    {
	    	System.out.println("orderItems not saved");
	    }
	    ortm.setOrderItemId("or102");
	    ortm.setProductId("p102");
	    
	    or=orDao.getOrder("o102");
	    ortm.setOrder(or);

	    if (ortmDao.saveorupdateOrderItems(ortm)==true)
	    {
	    	System.out.print("orderItems saved");
	    }
	    else
	    {
	    	System.out.print("orderItems not saved");
	    	
	    }
	    
	    
	    ortm.setOrderItemId("or103");
	    ortm.setProductId("p103");	 
	    or=orDao.getOrder("o102");
	    ortm.setOrder(or);

	    if(ortmDao.saveorupdateOrderItems(ortm)==true)
	    {
	    	System.out.print("orderItems is saved");
	    }
	    else
	    {
	    	System.out.print("orderItems is not saved");
	    }
	    ortm=ortmDao.getOrderItems("or101");
	    if(ortmDao.deleteOrderItems(ortm)==true)
	    	{
	    	System.out.println("orderItems deleted");
	    	}
	    else
	    {
	    	System.out.println("orderItems not deleted");
	    }
	    
	    ortm=ortmDao.getOrderItems("o102");
	    if(ortm==null)
	    {
	    	System.out.println("orderItems is not found");
	    }
	    else
	    {
	    	System.out.println(ortm.getOrderItemId());
	    	System.out.println(ortm.getProductId());
	    }
	    
	    List<OrderItems> ortmlist=ortmDao.list();
	    if(ortmlist==null||ortmlist.isEmpty())
	    {
	    	System.out.println("orderItems is empty");
	    }
	    else 
	    {
	    	for(OrderItems ortm1:ortmlist)
	    	{
	    		System.out.println(ortm1.getOrderItemId());
		    	System.out.println(ortm1.getProductId());	    	}
	    }
	//    
	    	}
	    }




