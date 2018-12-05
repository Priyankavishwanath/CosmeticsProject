package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Shipping;

public interface ShippingDao {
	public boolean saveorupdateShipping(Shipping Shipping);
	public boolean deleteShipping(Shipping Shipping);
	public Shipping getShipping(String ShippingId);
	public List<Shipping> list();
	public List<Shipping> getaddbyuser(String userId);
}


