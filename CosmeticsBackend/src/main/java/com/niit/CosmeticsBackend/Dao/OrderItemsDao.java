package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.OrderItems;

public interface OrderItemsDao {

	public boolean saveorupdateOrderItems(OrderItems OrderItems);
	public boolean deleteOrderItems(OrderItems OrderItems);
	public OrderItems getOrderItems(String OrderItemsId);
	public List<OrderItems> list();
}
