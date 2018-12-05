package com.niit.CosmeticsBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class CartItems {
	@Id
	
public String cartItemsId;
public double price;
public CartItems() {
	this.cartItemsId="CARTITEM"+UUID.randomUUID().toString().substring(30).toUpperCase();
}

@OneToOne
@JoinColumn(name="product")
private Product Product;

@ManyToOne
@JoinColumn(name="cartId")
private Cart cart;


public Product getProduct() {
	return Product;
}
public void setProduct(Product product) {
	Product = product;
}
public String getCartItemsId() {
	return cartItemsId;
}
public void setCartItemsId(String cartItemsId) {
	this.cartItemsId = cartItemsId;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
}

}
