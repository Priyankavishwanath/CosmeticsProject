package com.niit.CosmeticsBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class OrderItems {
	@Id
public String orderItemId;
public String productId;
public OrderItems() {
	this.orderItemId="ORD"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
@ManyToOne
@JoinColumn(name="orderId")
private Order order;

public String getOrderItemId() {
	return orderItemId;
}
public void setOrderItemId(String orderItemId) {
	this.orderItemId = orderItemId;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}

}
