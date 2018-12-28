package com.niit.CosmeticsFrontend.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.CosmeticsBackend.Dao.BillingDao;
import com.niit.CosmeticsBackend.Dao.CartDao;
import com.niit.CosmeticsBackend.Dao.CartItemsDao;
import com.niit.CosmeticsBackend.Dao.OrderDao;
import com.niit.CosmeticsBackend.Dao.OrderItemsDao;
import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Dao.ShippingDao;
import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.Model.Billing;
import com.niit.CosmeticsBackend.Model.Cart;
import com.niit.CosmeticsBackend.Model.CartItems;
import com.niit.CosmeticsBackend.Model.Order;
import com.niit.CosmeticsBackend.Model.OrderItems;
import com.niit.CosmeticsBackend.Model.Product;
import com.niit.CosmeticsBackend.Model.Shipping;
import com.niit.CosmeticsBackend.Model.User;

@Controller
public class OrderController {
	
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;
	//@Autowired
//	Card card;
//	@Autowired
//	CardDao cardDao;
//	@Autowired
	Billing billing;
	@Autowired
	BillingDao billingDao;
	@Autowired
	Shipping shipping;
	@Autowired
	ShippingDao shippingDao;
//	@Autowired
//	Pay pay;
//	@Autowired
//	PayDao payDao;
	@Autowired
	Order order;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItems orderItems;
	@Autowired
	OrderItemsDao orderItemsDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	List<CartItems> cartItems1;
	
//	@Autowired
 //   private JavaMailSender mailSender;
	
	String o;
	
	
	@RequestMapping("/Buyall")
	public String orderall(Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getUseremail(currusername);
			cart = user.getCart();
			product=null;			
			
//			session.setAttribute("products", product1);			
			cartItems1= cartItemsDao.getCartItemslist(cart.getCartId());
			if(cartItems1==null||cartItems1.isEmpty())
			{
				return "redirect:/viewcart";
			}
			else
			{
								
				billing = billingDao.getUser(user.getUserId());
				List<Shipping> shippingAddresies = shippingDao.getaddbyuser(user.getUserId());
				
				model.addAttribute("billing", billing);
				model.addAttribute("user", user);
				model.addAttribute("shippingAddresies", shippingAddresies);
				model.addAttribute("shippingAddress", new Shipping());
				session.setAttribute("p", product);
				model.addAttribute("prot", product);
			}
		}
			return "addressorder";
		} 
	
	

	@RequestMapping("/Buy/{productId}/{cartItemsId}")
	public String order(@PathVariable("productId") String id,@PathVariable("cartItemsId") String id2, Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getUseremail(currusername);
			cart = user.getCart();
			cartItems1=null;
			product = productDao.getproduct(id);
			billing = billingDao.getUser(user.getUserId());
			cartItems=cartItemsDao.getCartItems(id2);
			System.out.println(billing.getCountry());
//			for(Billing b: billing)
//			{
//				System.out.println(b.getBillId());
//				System.out.println(b.getCountry());
//			}
			List<Shipping> shippingAddresies = shippingDao.getaddbyuser(user.getUserId());
			user.setBilling(billing);
			model.addAttribute("billing", billing);
			model.addAttribute("user", user);
			model.addAttribute("shippingAddresies", shippingAddresies);
			model.addAttribute("shippingAddress", new Shipping());
			session.setAttribute("p", product);
			model.addAttribute("cartItems", cartItems);
			return "addressorder";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/orderConfirm")
	public String payment(@ModelAttribute("shippingAddress") Shipping sh, Model model) {
//		if(cartItems==null || cartItems.isEmpty())
//		{
//			System.out.println("sorry");
//		}
		sh.setUser(user);
		shipping = sh;
		model.addAttribute("billing", billing);
		model.addAttribute("shippingAddress", shipping);
		model.addAttribute("prot", product);
		model.addAttribute("cartItems",cartItems1);
		model.addAttribute("cart",cart);
		return "orderconfirm";
	}

	@RequestMapping("/previous")
	public String previous(Model model) {
		List<Shipping> shippingAddresies = shippingDao.getaddbyuser(user.getUserId());
		model.addAttribute("shippingAddresies", shippingAddresies);
		model.addAttribute("billing", billing);
		model.addAttribute("shippingAddress", shipping);
		model.addAttribute("product", product);
		
		return "addressorder";
	}

	
	@RequestMapping("/pay")
	public String pay(Model model) {
//		List<Card> cards = cardDao.getcardbyuser(user.getUserId());
//		model.addAttribute("cards", cards);
//		model.addAttribute("card", new Card());
		return "payment";
		
		
	}

	
	@RequestMapping("/payment")
	public String paymet(
//			@ModelAttribute("card") Card car,
			@RequestParam("otp") String otp,Model model) {
		int a;
		if(otp==null)
			a=2;
		else 
			a=1;
		switch (a) {
		case 1:
			if(otp.equals(o))
		     {
//				pay.setPaymentmethod("COD");
//				  pay.setPaymentstatus("NO");
				  break;	
		     }
			else{
				return "redirect:/orderconfirmation";
				
			}
		case 2:
			
//			pay.setPaymentmethod("Card");
//			pay.setPaymentstatus("yes");
//			payDao.saveorupdate(pay);
//			cardDao.saveorupdate(car);
			break;
		}

		return "redirect:/orderconfirmation";
	}
	
	
	
	
//	@RequestMapping("/payment")
//	public String payment(@RequestParam("payb2") String str, Model model) {
//				
// 		System.out.println(1324);
//		int a;
//		System.out.println(str);
//		if(str.equals(o))
//		{
//			return "redirect:/thankyou" ;	
//		}
//				
//return "redirect:/orderconfirmation";
//	}

	@RequestMapping("/orderconfirmation")
	public String orderconformation(HttpSession session) {
		System.out.println(32);
		order.setBilling(billing);
		order.setShipping(shipping);
//		order.setPay(pay);
		order.setUser(user);
		System.out.println(524);
		if (cartItems1 == null) 
		{
			order.setGrandTotal(product.getProductPrice());
			orderDao.saveorupdateOrder(order);
			orderItems.setOrder(order);
			orderItems.setProductId(product.getProductId());
			orderItemsDao.saveorupdateOrderItems(orderItems);
			cart.setGrandTotal(cart.getGrandTotal() - cartItems.getPrice());
			cart.setTotalItems(cart.getTotalItems() - 1);
			session.setAttribute("items", cart.getTotalItems());
			cartDao.saveorupdateCart(cart);
			cartItemsDao.delete(cartItemsDao.getlistall(cart.getCartId(),product.getProductId()).getCartItemsId());
			System.out.println(324);
		}
		else
		{ 
			System.out.println(656);
			order.setGrandTotal(cart.getGrandTotal());
			orderDao.saveorupdateOrder(order);
			for(CartItems c:cartItems1)
			{
				System.out.println(3444);
				orderItems.setOrder(order);
				orderItems.setProductId(c.getProduct().getProductId());
				System.out.println(3443);
				orderItemsDao.saveorupdateOrderItems(orderItems);
				cartItemsDao.deleteCartItems(c);
			}
			cart.setGrandTotal(0.0);
			cart.setTotalItems(0);
			System.out.println(346);
			session.setAttribute("items", cart.getTotalItems());
			cartDao.saveorupdateCart(cart);
		}
		cartItems=null;
		cartItems1=null;
		product=null;
		order=new Order();
		orderItems=new OrderItems();
		System.out.println(565);
		return "thankyou";
	}

//@RequestMapping(value="/SendMail")
//public void SendMail() {
//	System.out.println(21312);
//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//if (!(authentication instanceof AnonymousAuthenticationToken)) {
//	String currusername = authentication.getName();
//	user = userDao.getUseremail(currusername);      
//	OtpGenerator ot=new OtpGenerator();
////	String o=ot.Otpga();
//	o=ot.Otpga();
//	String recipientAddress = user.getUmail();
//	String subject="OTP";
////String subject = request.getParameter("subject");
//String message = "your one time password is "+o+" ";
//
//// prints debug info
//System.out.println("To:" + recipientAddress);
//System.out.println("Subject: " + subject);
//System.out.println("Message: " + message);
//
//    
////System.out.println("OTP:"+ otp);
//// creates a simple e-mail object
//SimpleMailMessage email = new SimpleMailMessage();
//email.setTo(recipientAddress);
//email.setSubject(subject);
//email.setText(message);
////email.setSubject(otp);
//// sends the e-mail
//mailSender.send(email);
//
// 
//// forwards to the view named "Result"
////return "Result";
//}
//}
//}



}

