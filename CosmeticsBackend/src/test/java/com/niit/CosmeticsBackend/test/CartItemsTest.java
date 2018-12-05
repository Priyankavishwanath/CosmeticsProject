package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.CartDao;
import com.niit.CosmeticsBackend.Dao.CartItemsDao;
import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Model.Cart;
import com.niit.CosmeticsBackend.Model.CartItems;
import com.niit.CosmeticsBackend.Model.Product;



public class CartItemsTest {

	public static void main (String args[])

	{
	    AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	    ctx.scan("com.niit.*");
	    ctx.refresh();
	    CartItems cartI=(CartItems)ctx.getBean("cartItems");
	    CartItemsDao cartIDao=(CartItemsDao)ctx.getBean("cartItemsDao");
	    Product product=(Product)ctx.getBean("product");
	    ProductDao productDao=(ProductDao)ctx.getBean("productDao");
	    Cart cart=(Cart)ctx.getBean("cart");
	    CartDao cartDao=(CartDao)ctx.getBean("cartDao");
	    
	    cartI.setCartItemsId("crtm101");
	    cartI.setPrice(111);
	    product=productDao.getproduct("p101");
	    cart=cartDao.getcart("cr101");
	    cartI.setProduct(product);
	    cartI.setCart(cart);
	    if(cartIDao.saveorupdateCartItems(cartI)==true)
	    {
	    	System.out.println("cartItems saved");
	    }
	    else
	    {
	    	System.out.println("cartItems not saved");
	    }
	    cartI.setCartItemsId("crtm102");
	    cartI.setPrice(222);
	    product=productDao.getproduct("p102");
	    cart=cartDao.getcart("cr102");
	    cartI.setProduct(product);
	    cartI.setCart(cart);


	    
	    
	    if (cartIDao.saveorupdateCartItems(cartI)==true)
	    {
	    	System.out.print("cartItems saved");
	    }
	    else
	    {
	    	System.out.print("cartItems not saved");
	    	
	    }
	    
	    
	    cartI.setCartItemsId("crtm103");
	    cartI.setPrice(333);
	    product=productDao.getproduct("p103");
	    cart=cartDao.getcart("cr103");
	    cartI.setProduct(product);
	    cartI.setCart(cart);


	    if(cartIDao.saveorupdateCartItems(cartI)==true)
	    {
	    	System.out.print("cartItems is saved");
	    }
	    else
	    {
	    	System.out.print("cartItems is not saved");
	    }
	    cartI=cartIDao.getCartItems("crtm101");
	    if(cartIDao.deleteCartItems(cartI)==true)
	    	{
	    	System.out.println("cartItems deleted");
	    	}
	    else
	    {
	    	System.out.println("cartItems not deleted");
	    }
	    
	    cartI=cartIDao.getCartItems("crtm102");
	    if(cartI==null)
	    {
	    	System.out.println("cartItems is not found");
	    }
	    else
	    {
	    	System.out.println(cartI.getCartItemsId());
	    	System.out.println(cartI.getPrice());
	    }
	    
	    List<CartItems> cartIlist=cartIDao.getlist();
	    if(cartIlist==null||cartIlist.isEmpty())
	    {
	    	System.out.println("cartItems is empty");
	    }
	    else 
	    {
	    	for(CartItems crtm:cartIlist)
	    	{
	    		System.out.println(crtm.getCartItemsId());
	    		System.out.println(crtm.getPrice());
	    	}
	    }
	//    
	    	}
	    }

	    

