package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Supplier;

public interface SupplierDao {

	public boolean saveorupdatesupplier(Supplier supplier);
	public boolean deletesupplier(Supplier supplier);
	public Supplier getsupplier(String supplierId);
	public List<Supplier> list();
}
