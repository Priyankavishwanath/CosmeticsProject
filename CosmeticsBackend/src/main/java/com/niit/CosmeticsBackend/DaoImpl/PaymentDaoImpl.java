package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.CosmeticsBackend.Dao.PaymentDao;
import com.niit.CosmeticsBackend.Model.Payment;

public class PaymentDaoImpl implements PaymentDao {
	
@Autowired
	SessionFactory  sessionfactory;
	public PaymentDaoImpl(SessionFactory sessionfactory) 
	{
	this.sessionfactory=sessionfactory;
	}
	
	public boolean saveorupdatepayment(Payment payment) {
		sessionfactory.getCurrentSession().saveOrUpdate(payment);
		return true;
	}

	public boolean deletepayment(Payment payment) {
		sessionfactory.getCurrentSession().delete(payment);
		return true;
	}

	public void getpayment(String payId) {
		String s="From Payment where payId='+payId+'";
		Query q=sessionfactory.getCurrentSession().createQuery(s);
		List<Payment>lpayment=(List<Payment>)q.list();
		if(lpayment==null||lpayment.isEmpty())
		{
			System.out.println("Payment not found");
			
			return;
}
	}


	@Override
	public boolean saveorupdate(Payment payment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Payment payment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Payment getPayment(String payId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> paylist() {
		// TODO Auto-generated method stub
		return null;
	}
}