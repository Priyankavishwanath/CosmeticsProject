package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.CartDao;
import com.niit.CosmeticsBackend.Model.Cart;
import com.niit.CosmeticsBackend.Model.Category;
@Repository("cartDao")
@Transactional
@EnableTransactionManagement
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Override
	public boolean saveorupdateCart(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	@Override
	public boolean deleteCart(Cart cart) {
		sessionFactory.getCurrentSession().delete(cart);
		return true;
	}

	@Override
	public Cart getcart(String cartId) {
		String s="From Cart where cartId='"+cartId+"'";
	    Query q = sessionFactory.getCurrentSession().createQuery(s);
	    List<Cart>lcart=(List<Cart>)q.list();
	    if(lcart==null||lcart.isEmpty())
	    {
	    	System.out.println("Cart not found");
		return null;
	    }
	    return lcart.get(0);
	}

	@Override
	public List<Cart> list() {
		List<Cart> cartlist=(List<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return cartlist;
	}
	
	}
	

