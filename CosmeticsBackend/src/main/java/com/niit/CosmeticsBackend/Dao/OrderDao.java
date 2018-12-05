package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Order;

public interface OrderDao {
	public boolean saveorupdateOrder(Order order);
	public boolean deleteOrder(Order Order);
	public Order getOrder(String OrderId);
	public List<Order> list();
}

