package com.niit.CosmeticsFrontend.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Product;
import com.niit.CosmeticsBackend.Model.Supplier;

@Controller
public class CategoryController {
	
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	
	
	@RequestMapping("/Category")
	public ModelAndView categoryform()
	{
		List<Category>categories=categoryDao.list();
		ModelAndView obj=new ModelAndView();
		obj.addObject("category", new Category());
		obj.addObject("categories", categories);
		obj.setViewName("Category");
		return obj;
	}
	
	@RequestMapping(value="/addcat", method=RequestMethod.POST)
	public ModelAndView addcategory(@ModelAttribute("category")Category category)
	{
		ModelAndView obj=new ModelAndView("redirect:/Category");
		// categoryDao.saveorupdate(category);
		//obj.addObject("echo","Category is added successfully");
		if(categoryDao.saveorupdateCategory(category)==true)
		{
			obj.addObject("echo","Category is added successfully");
		}
		else
		{
			obj.addObject("msg","sorry!");
			
		}
		return obj;
		}
	
	
	@RequestMapping("/edicat/{catId}")
	public ModelAndView editcategory(@PathVariable("catId")String catId)
	{
		System.out.println(123);
//		List<Product> products=productDao.list();
		List<Category> categories=categoryDao.list();
//		List<Supplier> supplies=supplierDao.list();
		ModelAndView obj=new ModelAndView("Category");
		category=categoryDao.getCategory(catId);
		obj.addObject("category", category);
//		product=productDao.getproduct(ProdId);
//		obj.addObject("product",product);
//		obj.addObject("products", products);
		obj.addObject("categories", categories);
//		obj.addObject("supplies", supplies);
		return obj;
		}
	
	
	@RequestMapping("/deletecategory/{catId}")
	public ModelAndView deleteCategory(@PathVariable("catId")String catId)
	{
		ModelAndView obj=new ModelAndView("redirect:/Category");
		category=categoryDao.getCategory(catId);
		// subCategory=subCategoryDao.getSubCatId(subCatId);
		//Category sublist=categoryDao.getCategory(catId);
		//list<Product>lists=productDao.getProductBySubCategory(subCategory);
//		List<Product>lists=productDao.getProductByCategory(catId);
		//List<Product>list=productDao.getProductByCategory(catId);
//		if(lists==null)
//		{
//			categoryDao.delete(category);
//			obj.addObject("msg","Category is deleted successfully");
//		}
//		else
//		{
//			for(Product productlist:lists)
//			{
//				productDao.delete(productlist);
//			}
		List<Category>categories=categoryDao.list();
			categoryDao.deleteCategory(category);
			obj.addObject("categories", categories);
			
//		}
		//categoryDao.delete(category);
		obj.addObject("msg","Category andSubCategory is deleted successfully");
		//obj.addObject("msg","Category not deleted");
		
		return obj;
	}
}


