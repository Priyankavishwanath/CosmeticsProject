package com.niit.CosmeticsBackend.test;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Model.Category;

public class CategoryTest {
	
public static void main (String args[])

{
    AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
    ctx.scan("com.niit.*");
    ctx.refresh();
    Category cat=(Category)ctx.getBean("category");
    CategoryDao catDao=(CategoryDao)ctx.getBean("categoryDao");
    cat.setCatId("c101");
    cat.setCatName("category1");
    if(catDao.saveorupdateCategory(cat)==true)
    {
    	System.out.println("category saved");
    }
    else
    {
    	System.out.println("category not saved");
    }
    cat.setCatId("c102");
    cat.setCatName("category2");
    if (catDao.saveorupdateCategory(cat)==true)
    {
    	System.out.print("category saved");
    }
    else
    {
    	System.out.print("category not saved");
    	
    }
    
    
    cat.setCatId("c103");
    cat.setCatName("category3");
    if(catDao.saveorupdateCategory(cat)==true)
    {
    	System.out.print("category is saved");
    }
    else
    {
    	System.out.print("category is not saved");
    }
    cat=catDao.getCategory("c101");
    if(catDao.deleteCategory(cat)==true)
    	{
    	System.out.println("category deleted");
    	}
    else
    {
    	System.out.println("category not deleted");
    }
    
    cat=catDao.getCategory("c102");
    if(cat==null)
    {
    	System.out.println("category is not found");
    }
    else
    {
    	System.out.println(cat.getCatId());
    	System.out.println(cat.getCatName());
    }
    
    List<Category> catlist=catDao.list();
    if(catlist==null||catlist.isEmpty())
    {
    	System.out.println("category is empty");
    }
    else 
    {
    	for(Category c:catlist)
    	{
    		System.out.println(c.getCatId());
    		System.out.println(c.getCatName());
    	}
    }
//    
    	}
    }

    