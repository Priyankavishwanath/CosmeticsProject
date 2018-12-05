package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.BillingDao;
import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.Model.Billing;
import com.niit.CosmeticsBackend.Model.User;



public class BillingTest {
	public static void main (String args[])

	{
	    AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	    ctx.scan("com.niit.*");
	    ctx.refresh();
	    Billing bill=(Billing)ctx.getBean("billing");
	    BillingDao billDao=(BillingDao)ctx.getBean("billingDao");
	    User user=(User)ctx.getBean("user");
	    UserDao userDao=(UserDao)ctx.getBean("userDao");
	    bill.setBillId("b101");
	    bill.setBillName("cosmetic");
	    bill.setBillAddress("gulbarga");
	    bill.setBillPhno("9035058922");
	    bill.setCountry("india");
	    user= userDao.getuser("u101");
	    bill.setUser(user);

	    if(billDao.saveorupdateBilling(bill)==true)
	    {
	    	System.out.println("billing saved");
	    }
	    else
	    {
	    	System.out.println("billing not saved");
	    }
	    bill.setBillId("b102");
	    bill.setBillName("cosmectic2");
	    bill.setBillAddress("hyderabad");
	    bill.setBillPhno("1111111111");
	    bill.setCountry("india");
	    user= userDao.getuser("u102");
	    bill.setUser(user);
	    

	    
	    if (billDao.saveorupdateBilling(bill)==true)
	    {
	    	System.out.print("billing saved");
	    }
	    else
	    {
	    	System.out.print("billing not saved");
	    	
	    }
	    
	    
	    bill.setBillId("b103");
	    bill.setBillName("cosmetic3");
	    user=userDao.getuser("u103");
	    bill.setUser(user);

	    if(billDao.saveorupdateBilling(bill)==true)
	    {
	    	System.out.print("billing is saved");
	    }
	    else
	    {
	    	System.out.print("billing is not saved");
	    }

	    bill=billDao.getBilling("b101");
	    if(billDao.deleteBilling(bill)==true)
	    	{
	    	System.out.println("billing deleted");
	    	}
	    else
	    {
	    	System.out.println("billing not deleted");
	    }
	    
	    bill=billDao.getBilling("b102");
	    if(bill==null)
	    {
	    	System.out.println("billing is not found");
	    }
	    else
	    {
	    	System.out.println(bill.getBillId());
	    	System.out.println(bill.getBillName());
	    	System.out.println(bill.getBillAddress());
	    	System.out.println(bill.getBillPhno());
	    	System.out.println(bill.getCountry());
	    	
	    }
	    
	    List<Billing> billlist=billDao.list();
	    if(billlist==null||billlist.isEmpty())
	    {
	    	System.out.println("billing is empty");
	    }
	    else 
	    {
	    	for(Billing b:billlist)
	    	{
	    		System.out.println(b.getBillId());
	    		System.out.println(b.getBillName());
	    		System.out.println(b.getBillAddress());
	    		System.out.println(b.getBillPhno());
	    		System.out.println(b.getCountry());
	    	}
	    }
	//    
	    	}
	    

	    
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }


