package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.CartDao;
import com.niit.CosmeticsBackend.Model.Cart;



public class CartTest {
 
	public static void main (String args[])

	{
	    AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	    ctx.scan("com.niit.*");
	    ctx.refresh();
	    Cart cart=(Cart)ctx.getBean("cart");
	    CartDao cartDao=(CartDao)ctx.getBean("cartDao");
	    
	    cart.setCartId("cr101");
	    cart.setGrandTotal(176.00);
	    cart.setTotalItems(1);
	    if(cartDao.saveorupdateCart(cart)==true)
	    {
	    	System.out.println("cart saved");
	    }
	    else
	    {
	    	System.out.println("cart not saved");
	    }
	    cart.setCartId("cr102");
	    cart.setGrandTotal(678.00);
	    cart.setTotalItems(6);
	    if (cartDao.saveorupdateCart(cart)==true)
	    {
	    	System.out.print("cart saved");
	    }
	    else
	    {
	    	System.out.print("cart not saved");
	    	
	    }
	    
	    
	    cart.setCartId("cr103");
	    cart.setGrandTotal(698.45);
	    cart.setTotalItems(7);
	    if(cartDao.saveorupdateCart(cart)==true)
	    {
	    	System.out.print("cart is saved");
	    }
	    else
	    {
	    	System.out.print("cart is not saved");
	    }
	    
	    cart=cartDao.getcart("cr101");
	    if(cartDao.deleteCart(cart)==true)
	    	{
	    	System.out.println("cart deleted");
	    	}
	    else
	    {
	    	System.out.println("cart not deleted");
	    }
	    
	    cart=cartDao.getcart("cr102");
	    if(cart==null)
	    {
	    	System.out.println("cart is not found");
	    }
	    else
	    {
	    	System.out.println(cart.getCartId());
	    	System.out.println(cart.getGrandTotal());
	    	System.out.println(cart.getTotalItems());
	    	
	    }
	    
	    List<Cart> cartlist=cartDao.list();
	    if(cartlist==null||cartlist.isEmpty())
	    {
	    	System.out.println("cart is empty");
	    }
	    else 
	    {
	    	for(Cart cr:cartlist)
	    	{
	    		System.out.println(cr.getCartId());
	    		System.out.println(cr.getGrandTotal());
	    		System.out.println(cr.getTotalItems());
	    	}
	    }   
	    	}
	    
}
