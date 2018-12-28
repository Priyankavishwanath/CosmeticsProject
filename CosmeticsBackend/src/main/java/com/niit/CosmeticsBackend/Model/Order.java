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
@Table(name="Orders")
@Component
public class Order {
	@Id
private String orderId;
private String orderDate;
private String orderTime;
private double grandTotal;
public Order() {
	this.orderId="order"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="billId")
private Billing Billing;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="shipId")
private Shipping shipping;

@OneToOne
@JoinColumn(name="userId")
private User user;
 
@OneToMany(mappedBy="order")
private List<OrderItems> orderItems;



public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
public String getOrderDate() {
	return orderDate;
}
public void setOrderDate(String orderDate) {
	this.orderDate = orderDate;
}
public String getOrderTime() {
	return orderTime;
}
public void setOrderTime(String orderTime) {
	this.orderTime = orderTime;
}
public double getGrandTotal() {
	return grandTotal;
}
public void setGrandTotal(double grandTotal) {
	this.grandTotal = grandTotal;
}
public Billing getBilling() {
	return Billing;
}
public void setBilling(Billing billing) {
	Billing = billing;
}
public Shipping getShipping() {
	return shipping;
}
public void setShipping(Shipping shipping) {
	this.shipping = shipping;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public List<OrderItems> getOrderItems() {
	return orderItems;
}
public void setOrderItems(List<OrderItems> orderItems) {
	this.orderItems = orderItems;
}


}
