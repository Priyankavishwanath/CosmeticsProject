package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.CartItems;

public interface CartItemsDao {
	public boolean saveorupdateCartItems(CartItems CartItems);
	public boolean deleteCartItems(CartItems cartItems);
	public CartItems getCartItems(String CartItemsId);
	public List<CartItems> getlist();
	public CartItems get(String cartId);
	public List<CartItems> getCartItemslist(String cartId);
	public CartItems getlistall(String cartId, String productId);
}
