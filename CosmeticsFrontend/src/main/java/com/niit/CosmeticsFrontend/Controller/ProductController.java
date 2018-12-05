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
import com.niit.CosmeticsBackend.Dao.SupplierDao;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Product;
import com.niit.CosmeticsBackend.Model.Supplier;
import com.niit.CosmeticsFrontend.FileInput.FileInput;

@Controller
public class ProductController {

	
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	
	String path="C:\\Users\\universal\\eclipse-workspace\\CosmeticsFrontend\\src\\main\\webapp\\resources\\images\\";
	
	@RequestMapping("/Product")
	public ModelAndView productform()
	{
		List<Product> products=productDao.list();
		List<Category> categories=categoryDao.list();
		List<Supplier> supplies=supplierDao.list();
		ModelAndView obj=new ModelAndView("Product");
//		ModelAndView obj1=new ModelAndView("Product");
		obj.addObject("supplier", new Supplier());
		obj.addObject("supplies", supplies);
		obj.addObject("category", new Category());
		obj.addObject("categories", categories);
		obj.addObject("product", new Product());
		obj.addObject("products", products);
		return obj;
	}
	
	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public ModelAndView addproduct(@ModelAttribute("Product")Product product)
	{
		ModelAndView obj= new ModelAndView("redirect:/Product");
		FileInput.upload(path,product.getPimg(),product.getProductId()+".jpg");
//		categoryDao.saveorupdate(category);
//		obj.addObject("echo", "Category is addes successfully");
		if(productDao.saveorupdateproduct(product)==true)
		{
			obj.addObject("echo", "Product is added successfully");
			
		}
		else
		{
			obj.addObject("msg","Sorry! Product is not added");
		}
		obj.setViewName("redirect:/Product");
		return obj;
	}

	
//	@RequestMapping(value="/addprod", method=RequestMethod.POST)
//	public ModelAndView addproduct(HttpServletRequest req, @ModelAttribute("product")Product product, @RequestParam("pimg") MultipartFile file, @ModelAttribute("user")User user) {
//		ModelAndView obj = new ModelAndView("redirect:/Product");
//		String filepath=req.getSession().getServletContext().getRealPath("/");
//		String filename=file.getOriginalFilename();
//		product.setImageName(filename);
//				productDao.saveorupdate(product);
//		
//		try
//		{
//			byte[] imagebyte= file.getBytes();
//			BufferedOutputStream fos= new BufferedOutputStream(new FileOutputStream(filepath+"/Resources/"+filename));
//				fos.write(imagebyte);
//			fos.close();
//		}
//		
//		catch(Exception e)
//		{
//			
//		}
//		return obj;
//	}

@RequestMapping("/editproduct/{ProdId}")
public ModelAndView editcategory(@PathVariable("ProdId")String ProdId)
{
	System.out.println(123);
	List<Product> products=productDao.list();
	List<Category> categories=categoryDao.list();
	List<Supplier> supplies=supplierDao.list();
	ModelAndView obj=new ModelAndView("Product");
	product=productDao.getproduct(ProdId);
	obj.addObject("product",product);
	obj.addObject("products", products);
	obj.addObject("categories", categories);
	obj.addObject("supplies", supplies);
	return obj;
	}
@RequestMapping("/deleteproduct/{ProdId}")
public ModelAndView deleteproduct(@PathVariable("ProdId")String ProdId)
{
	ModelAndView obj=new ModelAndView("redirect:/Product");
	product=productDao.getproduct(ProdId);
//	subCategory=subCategoryDao.getSubCatId(subCatId);
	Product sublist=productDao.getproduct(ProdId);
//	List<Product> lists= productDao.getProductBySubCategory(subCategory);
//	List<Product> lists=productDao.getProductByCategory(category);
//	if(sublist==null)
//	{
		productDao.deleteproduct(product);
		obj.addObject("msg","Product is deleted successfully");
//	}
//	else
//	{			
//		for(SubCategory s:sublist)				//Doubt section
//		{
//			List<Product> p=productDao.getProductBySubCategory(s);
//			
//			for(Product prodlist:p)
//			{
//			productDao.delete(prodlist);
//			}
//			subCategoryDao.delete(s);
//		}
//		categoryDao.delete(category);
//		obj.addObject("msg","Category and SubCategory is deleted successfully");
		obj.addObject("msg", "Product not deleted");
//	}
	return obj;
    }
	
}
