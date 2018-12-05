package com.niit.CosmeticsBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Payment {
	@Id
	private String payId;
	private String Method;
	public String Status;
	
	public Payment() {
		this.payId="PAY"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	@OneToMany(mappedBy = "Payment")
	private List<Payment> Payment;

	public List<Payment> getPayment() {
		return Payment;
	}

	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

}
