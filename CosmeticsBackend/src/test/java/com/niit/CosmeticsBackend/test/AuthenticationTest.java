package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.AuthenticationDao;
import com.niit.CosmeticsBackend.Model.Authentication;
import com.niit.CosmeticsBackend.Model.Category;

public class AuthenticationTest {
	public static void main (String args[])

	{
	    AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	    ctx.scan("com.niit.*");
	    ctx.refresh();
	    Authentication auth=(Authentication)ctx.getBean("authentication");
	    AuthenticationDao authDao=(AuthenticationDao)ctx.getBean("authenticationDao");
	    auth.setRoleId("a101");
	    auth.setRoleName("authentication1");
	    auth.setUserName("123");
	    if(authDao.saveorupdateAuthentication(auth)==true)
	    {
	    	System.out.println("authentication saved");
	    }
	    else
	    {
	    	System.out.println("authentication not saved");
	    }
	    auth.setRoleId("a102");
	    auth.setRoleName("authentication2");
	    auth.setUserName("456");
	    if(authDao.saveorupdateAuthentication(auth)==true)
	    {
	    	System.out.println("authentication saved");
	    }
	    else
	    {
	    	System.out.println("authentication is not saved");
	    	
	    }
	    auth.setRoleId("a103");
	    auth.setRoleName("authentication3");
	    auth.setUserName("789");
	    if(authDao.saveorupdateAuthentication(auth)==true)
	    {
	    	System.out.println("authentication saved");
	    }
	    else
	    {
	    	System.out.println("authentication is not saved");
	    }
	    auth=authDao.getAuthentication("a101");
	    if(authDao.deleteAuthentication(auth)==true)
	    	{
	    	System.out.println("authentication deleted");
	    	}
	    else
	    {
	    	System.out.println("authentication not deleted");
	    }
	    
	    auth=authDao.getAuthentication("a102");
	    if(auth==null)
	    {
	    	System.out.println("authentication is not found");
	    }
	    else
	    {
	    	System.out.println(auth.getRoleId());
	    	System.out.println(auth.getRoleName());
	    	System.out.println(auth.getUserName());
	    }

	    List<Authentication>authlist=authDao.list();
	    if(authlist==null||authlist.isEmpty())
	    {
	    	
	    	System.out.println("authentication is empty");
	    }
	    else
	    {
	    
	    	for(Authentication a:authlist)
	    	{
	    		System.out.println(a.getRoleId());
	    		System.out.println(a.getRoleName());
	    		System.out.println(a.getUserName());
	    	}
	    }
	//    
	    	}
	    }
	    	


