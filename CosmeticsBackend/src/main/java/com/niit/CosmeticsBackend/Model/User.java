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
public class User {
	@Id
private String userId;
private String userName;
private String userAdress;
private String userEmailid;
private String userPhno;
private String password;


@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="cartId")

private Cart cart;

@OneToMany(mappedBy="user")
private List<Shipping> shipping;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="billId")

private Billing billing;

public User() {
	this.userId="USE"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserAdress() {
	return userAdress;
}
public void setUserAdress(String userAdress) {
	this.userAdress = userAdress;
}
public String getUserEmailid() {
	return userEmailid;
}
public void setUserEmailid(String userEmailid) {
	this.userEmailid = userEmailid;
}
public String getUserPhno() {
	return userPhno;
}
public void setUserPhno(String userPhno) {
	this.userPhno = userPhno;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
}
public Billing getBilling() {
	return billing;
}
public void setBilling(Billing billing) {
	this.billing = billing;
}
public List<Shipping> getShipping() {
	return shipping;
}
public void setShipping(List<Shipping> shipping) {
	this.shipping = shipping;
}


}
