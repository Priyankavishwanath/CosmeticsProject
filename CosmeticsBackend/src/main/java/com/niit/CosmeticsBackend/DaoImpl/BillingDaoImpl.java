package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.BillingDao;
import com.niit.CosmeticsBackend.Model.Billing;

@Repository("billingDao")
@Transactional
@EnableTransactionManagement

public class BillingDaoImpl implements BillingDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public BillingDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdateBilling(Billing Billing) {
		sessionFactory.getCurrentSession().saveOrUpdate(Billing);
		return true;
	}

	@Override
	public boolean deleteBilling(Billing billing) {
		sessionFactory.getCurrentSession().delete(billing);
		return false;
	}

	public Billing getBilling(String billId) {
		String s="From Billing where  BillId='"+billId+"'";
	    Query q = sessionFactory.getCurrentSession().createQuery(s);
	    List<Billing>lbill=(List<Billing>)q.list();
	    if(lbill==null||lbill.isEmpty())
	    {
	    	System.out.println("Billing not found");
		return null;
	    }
	    return lbill.get(0);
	}

	@Override
	public List<Billing> list() {
		List<Billing> billinglist=(List<Billing>)sessionFactory.getCurrentSession().createCriteria(Billing.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return billinglist;
	}

	@Override
	public Billing getUser(String userId) {
		String s="From Billing where  userId='"+userId+"'";
	    Query q = sessionFactory.getCurrentSession().createQuery(s);
	    List<Billing>lbill=(List<Billing>)q.list();
	    if(lbill==null||lbill.isEmpty())
	    {
	    	System.out.println("Billing not found");
		return null;
	    }
	    return lbill.get(0);
	}

	


}
