package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.OrderItemsDao;
import com.niit.CosmeticsBackend.Model.OrderItems;

@Repository("orderItemsDao")
@Transactional
@EnableTransactionManagement

public class OrderItemsDaoImpl implements OrderItemsDao {
	

    @Autowired
    SessionFactory sessionFactory;
    
    public OrderItemsDaoImpl(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }


	@Override
	public boolean saveorupdateOrderItems(OrderItems OrderItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(OrderItems);
		return true;
	}

	@Override
	public boolean deleteOrderItems(OrderItems OrderItems) {
		sessionFactory.getCurrentSession().delete(OrderItems);

		return true;
	}

	@Override
	public OrderItems getOrderItems(String OrderItemsId) {
		String s="From OrderItems where orderItemId='"+OrderItemsId+"'";
		Query q =sessionFactory.getCurrentSession().createQuery(s);
		List<OrderItems> lOrderItems=(List<OrderItems>)q.list();
		if(lOrderItems==null||lOrderItems.isEmpty())
		{
			System.out.println("OrderItems not found");
		
		return null;
		}
		else
		{
		System.out.println("OrderItems list");	
		 return lOrderItems.get(0);}
		}
      

	@Override
	public List<OrderItems> list()
	{
List<OrderItems> OrderItems=(List<OrderItems>)sessionFactory.getCurrentSession().createCriteria(OrderItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
return OrderItems;
	}


}