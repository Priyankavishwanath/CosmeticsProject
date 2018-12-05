package com.niit.CosmeticsFrontend.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.User;

@Controller
public class LoginController {

	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error",required=false)String error,
			@RequestParam(value="logout",required=false)String logout,Model model)
	{
		if(error!=null)
		{
			System.out.println("t675786yjhgsh");
			model.addAttribute("error","invalid username or password");
		}
		if(logout!=null)
			model.addAttribute("logout","logout successfully");
		List<Category> categories= categoryDao.list();
		model.addAttribute("lcat", categories);
		return "Login";
	}
	@RequestMapping(value="/j_spring_security_check")
	public String Login(@RequestParam("j_username")String umail, @RequestParam("j_password")String pwd, Model model,HttpSession session)
{
	User user=userDao.isValid(umail,pwd);
	if(user==null)
	{
		
		System.out.println("t675786yjhgsh");
		model.addAttribute("msg","Invalid username pwd");
		return "redirect:/";
	}
	else
	{
		session.setAttribute("user",user);
		session.setAttribute("name",user.getUserName());
//	session.setAttribute("items",u.getCart().getTotal_items());
	return "redirect:/";
}
}
@RequestMapping(value="/j_spring_security_logout")
public String logout(HttpServletRequest request,HttpSession session,Model model)
{
	session.invalidate();
	session=request.getSession(true);
	model.addAttribute("logout","logout Successfully");
	return "redirect:/";
}
}