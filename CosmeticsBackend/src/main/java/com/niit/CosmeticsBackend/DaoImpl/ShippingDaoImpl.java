package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.ShippingDao;
import com.niit.CosmeticsBackend.Model.Shipping;
@Repository("shippingDao")
@Transactional
@EnableTransactionManagement
public class ShippingDaoImpl  implements ShippingDao{

	
	@Autowired
    SessionFactory sessionFactory;
    
    public ShippingDaoImpl(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }
	@Override
	public boolean saveorupdateShipping(Shipping Shipping) {
		sessionFactory.getCurrentSession().saveOrUpdate(Shipping);
		return true;
	}

	@Override
	public boolean deleteShipping(Shipping Shipping) {
		sessionFactory.getCurrentSession().delete(Shipping);
		return true;	}

	@Override
	public Shipping getShipping(String ShipId) {
		String s="From Shipping where shipId='"+ShipId+"'";
		Query q =sessionFactory.getCurrentSession().createQuery(s);
		List<Shipping>lShipping=(List<Shipping>)q.list();
		if(lShipping==null||lShipping.isEmpty())
		{
			System.out.println("Shipping not found");
		
		return null;
		}
		else
		{
		System.out.println("Shipping list");	
		 return lShipping.get(0);
		}
		}
      	@Override
      	public List<Shipping> list()
    	{
    List<Shipping> Shipping=(List<Shipping>)sessionFactory.getCurrentSession().createCriteria(Shipping.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    return Shipping;
    	}
		@Override
		public List<Shipping> getaddbyuser(String userId) {
			String s="From Shipping where userId='"+userId+"'";
			Query q =sessionFactory.getCurrentSession().createQuery(s);
			List<Shipping>lShipping=(List<Shipping>)q.list();
			if(lShipping==null||lShipping.isEmpty())
			{
				System.out.println("Shipping not found");
			
			return null;
			}
			else
			{
			System.out.println("Shipping list");	
			 return lShipping;
			}
		}

    }
