

package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.SupplierDao;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Supplier;

@Repository("supplierDao")
@EnableTransactionManagement
@Transactional
public class SupplierDaoImpl implements SupplierDao {
   @Autowired
   SessionFactory sessionFactory;
   public SupplierDaoImpl (SessionFactory sessionFactory)
   {
	   this.sessionFactory=sessionFactory;
   }
	@Override
	public boolean saveorupdatesupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
	}

	@Override
	public boolean deletesupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	}

	@Override
	public Supplier getsupplier(String supplierId) {
		String s="From Supplier where supplierId='"+supplierId+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		List<Supplier>lsupplier=(List<Supplier>)q.list();
		if(lsupplier==null||lsupplier.isEmpty())
		{
			System.out.println("Supplier not found");
			return null;
		}
		return lsupplier.get(0);	}

	@Override
	public List list() {
		List<Supplier> supplierlist=(List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return supplierlist;
	}

}
