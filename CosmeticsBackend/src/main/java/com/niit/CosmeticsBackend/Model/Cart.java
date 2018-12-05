package com.niit.CosmeticsBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Cart {
	@Id
private String cartId;
private double grandTotal=0;
private int totalItems=0;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="userId")

private User user;

public Cart() {
	this.cartId="CART"+UUID.randomUUID().toString().substring(30).toUpperCase();
}

@OneToMany(mappedBy="cart")
private List<CartItems> cartItems;


public List<CartItems> getCartItems() {
	return cartItems;
}

public void setCartItems(List<CartItems> cartItems) {
	this.cartItems = cartItems;
}

public String getCartId() {
	return cartId;
}

public void setCartId(String cartId) {
	this.cartId = cartId;
}
public double getGrandTotal() {
	return grandTotal;
}
public void setGrandTotal(double grandTotal) {
	this.grandTotal = grandTotal;
}
public int getTotalItems() {
	return totalItems;
}
public void setTotalItems(int totalItems) {
	this.totalItems = totalItems;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}


}
