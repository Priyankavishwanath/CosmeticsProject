package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Payment;

public interface PaymentDao {

	public boolean saveorupdate(Payment payment);
	public boolean delete(Payment payment);
	public Payment getPayment(String payId);
	public List<Payment> paylist();
	
	
}
