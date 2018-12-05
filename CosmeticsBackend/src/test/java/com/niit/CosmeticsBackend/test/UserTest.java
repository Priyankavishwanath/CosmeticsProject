
package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.User;

public class UserTest {
	public static void main (String args[])
	{
	    AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	    ctx.scan("com.niit.*");
	    ctx.refresh();
	    User user=(User)ctx.getBean("user");
	    UserDao userDao=(UserDao)ctx.getBean("userDao");
	    user.setUserId("u101");
	    user.setUserName("user1");
	    user.setUserAdress("sedam");
	    user.setUserEmailid("user123@gmail.com");
	    user.setUserPhno("9035058922");

	    
	    
	    if(userDao.saveorupdateuser(user)==true)
	    {
	    	System.out.println("user saved");
	    }
	    else
	    {
	    	System.out.println("user not saved");
	    }
	    user.setUserId("u102");
	    user.setUserName("user2");
	    user.setUserAdress("sedam");
	    user.setUserEmailid("user123@gmail.com");
	    user.setUserPhno("9035058922");
	    if (userDao.saveorupdateuser(user)==true)
	    {
	    	System.out.print("user saved");
	    }
	    else
	    {
	    	System.out.print("user not saved");
	    	
	    }
	    
	    
	    user.setUserId("u103");
	    user.setUserName("user3");
	    user.setUserAdress("sedam");
	    user.setUserEmailid("user123@gmail.com");
	    user.setUserPhno("9035058922");

	    
	    
	    if(userDao.saveorupdateuser(user)==true)
	    {
	    	System.out.print("user is saved");
	    }
	    else
	    {
	    	System.out.print("user is not saved");
	    }
	    user=userDao.getuser("u101");
	    if(userDao.deleteuser(user)==true)
	    	{
	    	System.out.println("user deleted");
	    	}
	    else
	    {
	    	System.out.println("user not deleted");
	    }
	    
	    user=userDao.getuser("u102");
	    if(user==null)
	    {
	    	System.out.println("user is not found");
	    }
	    else
	    {
	    	System.out.println(user.getUserId());
	    	System.out.println(user.getUserName());
	    }
	    
	    List<User> userlist=userDao.list();
	    if(userlist==null||userlist.isEmpty())
	    {
	    	System.out.println("user is empty");
	    }
	    else 
	    {
	    	for(User u:userlist)
	    	{
	    		System.out.println(u.getUserId());
	    		System.out.println(u.getUserName());
	    	}
	    }
	    
	    	}
	    }
	    

