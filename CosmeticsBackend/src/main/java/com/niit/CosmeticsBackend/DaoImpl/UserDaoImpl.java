package com.niit.CosmeticsBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.Model.Authentication;
import com.niit.CosmeticsBackend.Model.Billing;
import com.niit.CosmeticsBackend.Model.User;

@Repository("userDao")
@EnableTransactionManagement
@Transactional
public class UserDaoImpl implements UserDao {
@Autowired
SessionFactory sessionFactory;
    
  public UserDaoImpl(SessionFactory sessionFactory)
  {
	  this.sessionFactory=sessionFactory;
  }
	@Override
	public boolean saveorupdateuser(User user) {
		Billing b= new Billing();
		Authentication auth=new Authentication();
		auth.setUserName(user.getUserEmailid());
		b.setBillName(user.getUserName());
		b.setBillPhno(user.getUserPhno());
		b.setCountry(user.getUserAdress());
		b.setBillAddress(user.getUserAdress());
		b.setUser(user);
		user.setBilling(b);
		
		sessionFactory.getCurrentSession().saveOrUpdate(auth);
		sessionFactory.getCurrentSession().saveOrUpdate(b);		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

	@Override
	public boolean deleteuser(User user) {
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	@Override
	public User getuser(String userId) {
		String s="From User where userId='"+userId+"'";
	    Query q = sessionFactory.getCurrentSession().createQuery(s);
	    List<User>luser=(List<User>)q.list();
	    if(luser==null||luser.isEmpty())
	    {
	    	System.out.println("USer not found");
		return null;
	    }
	    return luser.get(0);
	}

	@Override
	public List<User>list() {
		List<User> userlist=(List<User>)sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return userlist;
		
	}
	@Override
	public User isValid(String umail, String pwd) {
		String s="from User where userEmailid='"+umail+"' and password='"+pwd+"'";
	    Query q = sessionFactory.getCurrentSession().createQuery(s);
	    List<User> luser=(List<User>)q.list();
	    if(luser==null||luser.isEmpty())
	    {
	    	System.out.println("USer not found");
	    	return null;
	    }
	    return luser.get(0);
	}
	@Override
	public User getUseremail(String currusername) {
		String s="from User where userEmailid='"+currusername+"'";
	    Query q = sessionFactory.getCurrentSession().createQuery(s);
	    List<User> luser=(List<User>)q.list();
	    if(luser==null||luser.isEmpty())
	    {
	    	System.out.println("USer not found");
	    	return null;
	    }
	    return luser.get(0);
	}

}
