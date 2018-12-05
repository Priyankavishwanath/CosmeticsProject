package com.niit.CosmeticsBackend.DaoImpl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.AuthenticationDao;
import com.niit.CosmeticsBackend.Model.Authentication;
import com.niit.CosmeticsBackend.Model.Category;

@Repository("authenticationDao")
@Transactional
@EnableTransactionManagement
public class AuthenticationDaoImpl implements AuthenticationDao {
	@Autowired
	SessionFactory sessionFactory;

	public AuthenticationDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveorupdateAuthentication(Authentication authentication) {
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		return true;
	}

	@Override
	public boolean deleteAuthentication(Authentication authentication) {
		sessionFactory.getCurrentSession().delete(authentication);
		return true;
	}

	@Override
	public Authentication getAuthentication(String roleId) {
		String s = "From Authentication where roleId='" + roleId + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(s);
		List<Authentication> lcat = (List<Authentication>) q.list();
		if (lcat == null || lcat.isEmpty()) {
			System.out.println("Authentication not found");
			return null;
		}
		return lcat.get(0);
	}

	@Override
	public List<Authentication> list() {
		List<Authentication> catlist = (List<Authentication>) sessionFactory.getCurrentSession()
				.createCriteria(Authentication.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return catlist;
	}

}
