package com.niit.CosmeticsBackend.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.CosmeticsBackend.Dao.AuthenticationDao;
import com.niit.CosmeticsBackend.Dao.BillingDao;
import com.niit.CosmeticsBackend.Dao.CartDao;
import com.niit.CosmeticsBackend.Dao.CartItemsDao;
import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.OrderDao;
import com.niit.CosmeticsBackend.Dao.OrderItemsDao;
import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Dao.ShippingDao;
import com.niit.CosmeticsBackend.Dao.SupplierDao;
import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.DaoImpl.AuthenticationDaoImpl;
import com.niit.CosmeticsBackend.DaoImpl.BillingDaoImpl;
import com.niit.CosmeticsBackend.DaoImpl.CartDaoImpl;
import com.niit.CosmeticsBackend.DaoImpl.CartItemsDaoImpl;
import com.niit.CosmeticsBackend.DaoImpl.CategoryDaoImpl;
import com.niit.CosmeticsBackend.DaoImpl.OrderDaoImpl;
import com.niit.CosmeticsBackend.DaoImpl.OrderItemsDaoImpl;
import com.niit.CosmeticsBackend.DaoImpl.ProductDaoImpl;
import com.niit.CosmeticsBackend.DaoImpl.ShippingDaoImpl;
import com.niit.CosmeticsBackend.DaoImpl.SupplierDaoImpl;
import com.niit.CosmeticsBackend.DaoImpl.UserDaoImpl;
import com.niit.CosmeticsBackend.Model.Authentication;
import com.niit.CosmeticsBackend.Model.Billing;
import com.niit.CosmeticsBackend.Model.Cart;
import com.niit.CosmeticsBackend.Model.CartItems;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Order;
import com.niit.CosmeticsBackend.Model.OrderItems;
import com.niit.CosmeticsBackend.Model.Product;
import com.niit.CosmeticsBackend.Model.Shipping;
import com.niit.CosmeticsBackend.Model.Supplier;
import com.niit.CosmeticsBackend.Model.User;

@Configuration

@ComponentScan("com.niit.*")
@EnableTransactionManagement

public class ApplicationContext {
	
	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/Cosmetics1");
		dataSource.setUsername("priyanka");
		dataSource.setPassword("priyanka");
		return dataSource;
	}
	private Properties gethibernateproperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.connection.pool_size","10");
	    properties.put("hibernate.hbm2ddl.auto","update");
	    properties.put("hibernate.show_sql","true");
	    properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	    return properties;
	}
	@Autowired
	@Bean("sessionFactory")
	 public SessionFactory getsessionfactory(DataSource datasource)
	 {
		 LocalSessionFactoryBuilder sessionbuilder=new LocalSessionFactoryBuilder((DataSource) datasource);
		 //Add All MOdel Classes
		 sessionbuilder.addProperties(gethibernateproperties());
		 sessionbuilder.addAnnotatedClass(Category.class);
		 sessionbuilder.addAnnotatedClass(Product.class);
		 sessionbuilder.addAnnotatedClass(Supplier.class);
		 sessionbuilder.addAnnotatedClass(User.class);
		 sessionbuilder.addAnnotatedClass(Authentication.class);
		 sessionbuilder.addAnnotatedClass(Billing.class);
		 sessionbuilder.addAnnotatedClass(Cart.class);
		 sessionbuilder.addAnnotatedClass(CartItems.class);
		 sessionbuilder.addAnnotatedClass(Order.class);
		 sessionbuilder.addAnnotatedClass(OrderItems.class);
		 sessionbuilder.addAnnotatedClass(Shipping.class);
		 
		 return sessionbuilder.buildSessionFactory();
	 }
	 @Autowired
		@Bean("transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}

		@Autowired
		@Bean("categoryDao")
		public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
			return new CategoryDaoImpl(sessionFactory);
		}

		@Autowired
		@Bean("productDao")
		public ProductDao getProductDao(SessionFactory sessionFactory) {
			return new ProductDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("supplierDao")
		public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
			return new SupplierDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean("userDao")
		public UserDao getUserDao(SessionFactory sessionFactory) {
			return new UserDaoImpl(sessionFactory);
		}
	 

		@Autowired
		@Bean("authenticationDao")
		public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) {
			return new AuthenticationDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("billingDao")
		public BillingDao getBillingDao(SessionFactory sessionFactory) {
			return new BillingDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("orderDao")
		public OrderDao getorderDao(SessionFactory sessionFactory) {
			return new OrderDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean("orderItemsDao")
		public OrderItemsDao getoderItemsDao(SessionFactory sessionFactory) {
			return new OrderItemsDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean("cartDao")
		public CartDao getcartDao(SessionFactory sessionFactory) {
			return new CartDaoImpl(sessionFactory);
			
		}
		@Autowired
		@Bean("cartItemsDao")
		public CartItemsDao getcartItemsDao(SessionFactory sessionFactory) {
			return new CartItemsDaoImpl(sessionFactory);
			
		}
		@Autowired
		@Bean("shippingDao")
		public ShippingDao getshippingDao(SessionFactory sessionFactory) {
			return new ShippingDaoImpl(sessionFactory);
	}
}
		

