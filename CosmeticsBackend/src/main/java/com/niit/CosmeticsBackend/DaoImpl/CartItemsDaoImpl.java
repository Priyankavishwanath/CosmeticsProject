package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.CartItemsDao;
import com.niit.CosmeticsBackend.Model.CartItems;
@Repository("cartItemsDao")
@Transactional
@EnableTransactionManagement

public class CartItemsDaoImpl implements CartItemsDao
{
	
	  @Autowired
	    SessionFactory sessionFactory;
	    
	    public CartItemsDaoImpl(SessionFactory sessionFactory)
	    {
	    	this.sessionFactory=sessionFactory;
	    }



	@Override
	public boolean saveorupdateCartItems(CartItems CartItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(CartItems);
		return true;
	}

	@Override
	public boolean deleteCartItems(CartItems CartItems) {
		sessionFactory.getCurrentSession().delete(CartItems);

		return true;
	}

	@Override
	public CartItems getCartItems(String CartItemsId) {
		String s="From CartItems where CartItemsId='"+CartItemsId+"'";
		Query q =sessionFactory.getCurrentSession().createQuery(s);
		List<CartItems>lCartItems=(List<CartItems>)q.list();
		if(lCartItems==null||lCartItems.isEmpty())
		{
			System.out.println("CartItems not found");
		
		return null;
		}
		else
		{
		System.out.println("CartItems list");	
		 return lCartItems.get(0);
		}
		}
      

	public List<CartItems> list()
	{
List<CartItems> CartItems=(List<CartItems>)sessionFactory.getCurrentSession().createCriteria(CartItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
return CartItems;
	}



	@Override
	public CartItems get(String cartId) {
		String s="From CartItems where cartId='"+cartId+"'";
		Query q =sessionFactory.getCurrentSession().createQuery(s);
		List<CartItems>lCartItems=(List<CartItems>)q.list();
		if(lCartItems==null||lCartItems.isEmpty())
		{
			System.out.println("CartItems not found");
		
		return null;
		}
		else
		{
		System.out.println("CartItems list");	
		 return lCartItems.get(0);
		}
	}



	@Override
	public List<CartItems> getlist() {
		List<CartItems> cartitms = (List<CartItems>) sessionFactory.getCurrentSession().createCriteria(CartItems.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return cartitms;
	}



	@Override
	public List<CartItems> getCartItemslist(String cartId) {
		String Sq1="From CartItems where cartId='"+cartId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(Sq1);
		@SuppressWarnings("unchecked")
		List<CartItems> list=(List<CartItems>)q1.list();
		if(list==null||list.isEmpty())
		{
			System.out.println("Item is not found");
			return null;
		}
		else
		{
			return list;
		}
		
	}



	@Override
	public CartItems getlistall(String cartId, String productId) {
		String sql= "from CartItems where cartId='" +cartId+ "'and productId ='" +productId+ "'";
		Query q1= sessionFactory.getCurrentSession().createQuery(sql);
		@SuppressWarnings("unchecked")
		List<CartItems> list=(List<CartItems>) q1.list();
		if(list==null || list.isEmpty()){
			System.out.println("Item is not found");
			return null;
		}
		else
		{
			return list.get(0);
		}
	}



	@Override
	public boolean delete(String cartItemsId) {
		CartItems c= new CartItems();
		c.setCartItemsId(cartItemsId);
		sessionFactory.getCurrentSession().delete(c);
		return true;
	}
	
}
	