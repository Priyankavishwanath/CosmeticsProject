package com.niit.CosmeticsFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Product;

@Controller
public class HomeController {
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;

	@RequestMapping("/")
	public String home(Model model)
	{
		ModelAndView obj=new ModelAndView("Product");
		List<Product> prodlist=productDao.list();
		List<Category> catlist=categoryDao.list();
		//List<SubCategory> subcatlist=subCategoryDao.list();
		//List<SubCategory> scatlist=subCategoryDao.getSubCategoryByCategory(category);
		model.addAttribute("categories",catlist);
		//model.addAttribute("scats",scatlist);
		//model.addAttribute("subcategories",subcatlist);
		obj.addObject("product",product);
		model.addAttribute("products", prodlist);
		return "home";
	}

@RequestMapping("/Gallery")
public String Gallery(Model model)
{
	List<Category> categories=categoryDao.list();
	List<Product> products=productDao.list();
	model.addAttribute("categories", categories);
	model.addAttribute("products", products);
	return"Gallery";
}

}


	