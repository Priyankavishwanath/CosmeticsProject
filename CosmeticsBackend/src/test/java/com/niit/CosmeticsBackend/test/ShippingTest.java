package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.ShippingDao;
import com.niit.CosmeticsBackend.Model.Shipping;

public class ShippingTest {

	public static void main (String args[])

	{
	    AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	    ctx.scan("com.niit.*");
	    ctx.refresh();
	    Shipping ship=(Shipping)ctx.getBean("shipping");
	    ShippingDao shipDao=(ShippingDao)ctx.getBean("shippingDao");
	    ship.setShipId("ship101");
	    ship.setShipName("ship1");
	    ship.setAddress("gulbarga");
	    ship.setPhno("9035058922");
	    if(shipDao.saveorupdateShipping(ship)==true)
	    {
	    	System.out.println("shipping saved");
	    }
	    else
	    {
	    	System.out.println("shipping not saved");
	    }
	    ship.setShipId("ship102");
	    ship.setShipName("ship2");
	    ship.setAddress("gulbarga");
	    ship.setPhno("9035058922");
	    if (shipDao.saveorupdateShipping(ship)==true)
	    {
	    	System.out.print("shipping saved");
	    }
	    else
	    {
	    	System.out.print("shipping not saved");
	    	
	    }
	    
	    
	    ship.setShipId("ship103");
	    ship.setShipName("ship3");
	    ship.setAddress("gulbarga");
	    ship.setPhno("9035058922");
	    if(shipDao.saveorupdateShipping(ship)==true)
	    {
	    	System.out.print("shipping is saved");
	    }
	    else
	    {
	    	System.out.print("shipping is not saved");
	    }
	    ship=shipDao.getShipping("ship101");
	    if(shipDao.deleteShipping(ship)==true)
	    	{
	    	System.out.println("shipping deleted");
	    	}
	    else
	    {
	    	System.out.println("shipping not deleted");
	    }
	    
	    ship=shipDao.getShipping("ship102");
	    if(ship==null)
	    {
	    	System.out.println("shipping is not found");
	    }
	    else
	    {
	    	System.out.println(ship.getShipId());
	    	System.out.println(ship.getShipName());
	    	System.out.println(ship.getAddress());
	    	System.out.println(ship.getPhno())	;
	    	}
	    
	    List<Shipping> shiplist=shipDao.list();
	    if(shiplist==null||shiplist.isEmpty())
	    {
	    	System.out.println("shipping is empty");
	    }
	    else 
	    {
	    	for(Shipping sh:shiplist)
	    	{
	    		System.out.println(sh.getShipId());
	    		System.out.println(sh.getShipName());
	    		System.out.println(sh.getAddress());
	    		System.out.println(ship.getPhno());
	    	}
	    }
	//    
	    	}
	    }



