package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.BillingDao;
import com.niit.CosmeticsBackend.Dao.OrderDao;
import com.niit.CosmeticsBackend.Dao.ShippingDao;
import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.Model.Billing;
import com.niit.CosmeticsBackend.Model.Order;
import com.niit.CosmeticsBackend.Model.Shipping;
import com.niit.CosmeticsBackend.Model.User;


public class OrderTest {

	public static void main (String args[])

	{
	    AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	    ctx.scan("com.niit.*");
	    ctx.refresh();
	    Order or=(Order)ctx.getBean("order");
	    OrderDao orDao=(OrderDao)ctx.getBean("orderDao");
	    Billing bill=(Billing)ctx.getBean("billing");
	    BillingDao billDao=(BillingDao)ctx.getBean("billingDao");
	    Shipping ship=(Shipping)ctx.getBean("shipping");
	    ShippingDao shipDao=(ShippingDao)ctx.getBean("shippingDao");
	    User user=(User)ctx.getBean("user");
	    UserDao userDao=(UserDao)ctx.getBean("userDao");
	    or.setOrderId("o101");
	    bill=billDao.getBilling("b101");
	    ship=shipDao.getShipping("ship101");
	    user=userDao.getuser("u101");
	    or.setBilling(bill);
	    or.setShipping(ship);
	    or.setUser(user);

	    or.setOrderDate("11 july");
	    or.setOrderTime("12pm");
	    or.setGrandTotal(111.00);
	    
	    if(orDao.saveorupdateOrder(or)==true)
	    {
	    	System.out.println("order saved");
	    }
	    else
	    {
	    	System.out.println("order not saved");
	    }
	    or.setOrderId("o102");
	    or.setOrderDate("11 july");
	    or.setOrderTime("12pm");
	    or.setGrandTotal(187.00);
	    
	    bill=billDao.getBilling("b102");
	    ship=shipDao.getShipping("ship102");
	    user=userDao.getuser("u102");
	    or.setBilling(bill);
	    or.setShipping(ship);
	    or.setUser(user);



	    if (orDao.saveorupdateOrder(or)==true)
	    {
	    	System.out.print("order saved");
	    }
	    else
	    {
	    	System.out.print("order not saved");
	    	
	    }
	    
	    
	    or.setOrderId("o103");
	  
        or.setOrderDate("11 july");
	    or.setOrderTime("12pm");
	    or.setGrandTotal(165.06);
	    bill=billDao.getBilling("b103");
	    ship=shipDao.getShipping("ship103");
	    user=userDao.getuser("u103");
	    or.setBilling(bill);
	    or.setShipping(ship);
	    or.setUser(user);



	    if(orDao.saveorupdateOrder(or)==true)
	    {
	    	System.out.print("order is saved");
	    }
	    else
	    {
	    	System.out.print("order is not saved");
	    }
	    or=orDao.getOrder("o101");
	    if(orDao.deleteOrder(or)==true)
	    	{
	    	System.out.println("order deleted");
	    	}
	    else
	    {
	    	System.out.println("order not deleted");
	    }
	    
	    or=orDao.getOrder("o102");
	    if(or==null)
	    {
	    	System.out.println("order is not found");
	    }
	    else
	    {
	    	System.out.println(or.getOrderId());
	    	System.out.println(or.getOrderDate());
	    	System.out.println(or.getOrderTime());
	    }
	    
	    List<Order> orlist=orDao.list();
	    if(orlist==null||orlist.isEmpty())
	    {
	    	System.out.println("order is empty");
	    }
	    else 
	    {
	    	for(Order o:orlist)
	    	{
	    		System.out.println(or.getOrderId());
		    	System.out.println(or.getOrderDate());
		    	System.out.println(or.getOrderTime());
	    	}
	    }
	//    
	    	}
	    }



