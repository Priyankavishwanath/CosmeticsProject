package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Product;

@Repository("productDao")
@EnableTransactionManagement
@Transactional
public class ProductDaoImpl  implements ProductDao
{
    @Autowired
    SessionFactory sessionFactory;
    
    @Autowired
    CategoryDao categoryDao;
    
    public ProductDaoImpl(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }

	@Override
	public boolean saveorupdateproduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}

	@Override
	public boolean deleteproduct(Product product) {
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}

	@Override
	public Product getproduct(String productId) {
		String s="From Product where productId='"+productId+"'";
		Query q =sessionFactory.getCurrentSession().createQuery(s);
		List<Product>lproduct=(List<Product>)q.list();
		if(lproduct==null||lproduct.isEmpty())
		{
			System.out.println("Product not found");
		
		return null;
		}
		else
		{
		System.out.println("Product list");	
		 return lproduct.get(0);
		}
      
}
	@Override
	public List<Product> list()
	{
List<Product> Products=(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
return Products;
	}

	@Override
	public List<Product> getProductByCategory(String catId) {
		String s1="from Product where catId='"+catId+"'";
		Query q1 =sessionFactory.getCurrentSession().createQuery(s1);
		List<Product> lproduct=(List<Product>)q1.list();
		
		if(lproduct==null||lproduct.isEmpty())
		{
			System.out.println("Product not found");
		
		return null;
		}
		else
		{
		System.out.println("Product list");	
		 return lproduct;
		}
	}

}
