package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Cart;

public interface CartDao {

	public boolean saveorupdateCart(Cart cart);
	public boolean deleteCart(Cart Cart);
	public Cart getcart(String Cart);
	public List<Cart> list();
}
