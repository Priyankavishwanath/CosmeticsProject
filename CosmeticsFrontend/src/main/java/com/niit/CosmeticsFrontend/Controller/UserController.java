package com.niit.CosmeticsFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.Model.Cart;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.User;

@Controller
public class UserController {

	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/User")
	public ModelAndView userform()
	{
		List<User> users=userDao.list();
		ModelAndView obj=new ModelAndView("User");
		List<Category> catlist=categoryDao.list();
		obj.addObject("categories",catlist);
		obj.addObject("user", new User());
		obj.addObject("users", users);
		return obj;
	}
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public ModelAndView adduser(@ModelAttribute("user")User user)
	{
		ModelAndView obj= new ModelAndView("redirect:/User");
//		categoryDao.saveorupdate(category);
//		obj.addObject("echo", "Category is addes successfully");
		Cart c= new Cart();
		c.setUser(user);
		user.setCart(c);
		if(userDao.saveorupdateuser(user)==true)
		{
			obj.addObject("echo", "User is added successfully");
			
		}
		else
		{
			obj.addObject("msg","Sorry! User is not added");
		}
	    obj.setViewName("redirect:/User");
		return obj;
	}

}