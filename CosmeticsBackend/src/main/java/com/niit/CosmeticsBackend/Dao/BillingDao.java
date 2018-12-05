package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Billing;
import com.niit.CosmeticsBackend.Model.Category;

public interface BillingDao {

	public boolean saveorupdateBilling(Billing bill);
	public boolean deleteBilling(Billing Billing);
	public Billing getBilling(String BillId);
	public List<Billing> list();
	public Billing getUser(String userId);
	
}
