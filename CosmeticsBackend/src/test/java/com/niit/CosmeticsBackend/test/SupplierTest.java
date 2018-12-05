package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.SupplierDao;
import com.niit.CosmeticsBackend.Model.Supplier;

public class SupplierTest {
	public static void main (String args[])
	{
	    AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	    ctx.scan("com.niit.*");
	    ctx.refresh();
	    Supplier supplier=(Supplier)ctx.getBean("supplier");
	    SupplierDao supplierDao=(SupplierDao)ctx.getBean("supplierDao");
	    supplier.setSupplierId("s101");
	    supplier.setSupplierName("supplier1");
	    supplier.setSupplierEmailid("supp@gmail.com");
	    supplier.setSupplierAddress("gulbarga");
	    supplier.setSupplierPhno("9035058922");
	    if(supplierDao.saveorupdatesupplier(supplier)==true)
	    {
	    	System.out.println("supplier saved");
	    }
	    else
	    {
	    	System.out.println("supplier not saved");
	    }
	    supplier.setSupplierId("s102");
	    supplier.setSupplierName("supplier2");
	    supplier.setSupplierEmailid("supp@gmail.com");
	    supplier.setSupplierAddress("gulbarga");
	    supplier.setSupplierPhno("9035058922");
	    
	    
	    if (supplierDao.saveorupdatesupplier(supplier)==true)
	    {
	    	System.out.print("supplier is  saved");
	    }
	    else
	    {
	    	System.out.print("supplier not saved");
	    	
	    }
	    
	    
	    supplier.setSupplierId("s103");
	    supplier.setSupplierName("supplier3");
	    supplier.setSupplierEmailid("supp@gmail.com");
	    supplier.setSupplierAddress("gulbarga");
	    supplier.setSupplierPhno("9035058922");
	    
	    
	    if(supplierDao.saveorupdatesupplier(supplier)==true)
	    {
	    	System.out.print("supplier is saved");
	    }
	    else
	    {
	    	System.out.print("supplier is not saved");
	    }
	    supplier=supplierDao.getsupplier("s101");
	    if(supplierDao.deletesupplier(supplier)==true)
	    	{
	    	System.out.println("supplier deleted");
	    	}
	    else
	    {
	    	System.out.println("supplier not deleted");
	    }
	    
	    supplier=supplierDao.getsupplier("s102");
	    if(supplier==null)
	    {
	    	System.out.println("supplier is not found");
	    }
	    else
	    {
	    	System.out.println(supplier.getSupplierId());
	    	System.out.println(supplier.getSupplierName());
	    }
	    
	    List<Supplier> supplierlist=supplierDao.list();
	    if(supplierlist==null||supplierlist.isEmpty())
	    {
	    	System.out.println("supplier is empty");
	    }
	    else 
	    {
	    	for(Supplier s:supplierlist)
	    	{
	    		System.out.println(s.getSupplierId());
	    		System.out.println(s.getSupplierName());
	    	}
	    }
	    
	    	}
	    }
	    

