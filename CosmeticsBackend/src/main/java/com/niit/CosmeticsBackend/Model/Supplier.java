package com.niit.CosmeticsBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier {
	@Id
	private String supplierId;
	private String supplierName;
	private String supplierAddress;
	private String supplierEmailid;
	private String supplierPhno;
	
	public Supplier() {
		this.supplierId="SUPP"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierEmailid() {
		return supplierEmailid;
	}
	public void setSupplierEmailid(String supplierEmailid) {
		this.supplierEmailid = supplierEmailid;
	}
	public String getSupplierPhno() {
		return supplierPhno;
	}
	public void setSupplierPhno(String supplierPhno) {
		this.supplierPhno = supplierPhno;
	}
	

}
