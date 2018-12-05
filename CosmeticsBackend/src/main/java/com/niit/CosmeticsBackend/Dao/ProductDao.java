package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Product;

public interface ProductDao{
public boolean saveorupdateproduct(Product product);
public boolean deleteproduct(Product product);
public Product getproduct(String productId);
public List<Product>list();
}
