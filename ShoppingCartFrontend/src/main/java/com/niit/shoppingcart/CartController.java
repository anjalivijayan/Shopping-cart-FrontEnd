package com.niit.shoppingcart;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class CartController {
	
	Logger log = LoggerFactory.getLogger(CartController.class);
	@Autowired(required = true)
	private CartDAO cartDAO;

	@Autowired(required = true)
	private ProductDAO productDAO;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired(required = true)
	private CategoryDAO categoryDAO;

	@Autowired
	private UserDetails userDAO;

	@Autowired
	private Cart cart;
	
	

	@RequestMapping(value = "/myCart")
	public String myCart(Model model, HttpSession session) {
		log.debug("Start: method myCart");
		Session s=sessionFactory.openSession();
		UserDetails user = (UserDetails)session.getAttribute("user");
		model.addAttribute("userClickedCartHere", true);
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", categoryDAO.list());
		cart = cartDAO.getByUserId(user.getId());
		model.addAttribute("cart", cart);
		model.addAttribute("cartList", cartDAO.userCartList(user.getId()));
		System.out.println(cartDAO.getTotalAmount(user.getId()));
		model.addAttribute("totalAmount", cartDAO.getTotalAmount(user.getId())); 
		model.addAttribute("displayCart", "true");
		log.debug("End: method myCart");
		return "/Home";
	}

	
	

	// For add and update cart both
	@RequestMapping(value = "/cart/add/{id}", method = RequestMethod.GET)
	public String addToCart(@PathVariable("id") String id, HttpSession session) {
		log.debug("Start: method addToCart");
		log.info("\n*************\nproductID is {}\n*************\n", id);
		UserDetails user=   (UserDetails) session.getAttribute("user");
		log.info("\n*************\nuserID is {}\n*************\n", user.getId());
		session.setAttribute("cartSize", cartDAO.userCartList(id).size());

		Product product = productDAO.get(id);
		Cart cart = new Cart();
		log.info("\n*************\ncartID is {}\n*************\n", cart.getId());
		cart.setPrice(product.getPrice());
		cart.setProductName(product.getName());
		cart.setProduct(product);
		cart.setQuantity(1);
		cart.setUser(user); // id should keep session and
							// use the same id
		cart.setStatus('N'); //
		cartDAO.saveOrUpdate(cart);
		// return "redirect:/views/home.jsp";
		log.debug("End: method addToCart");
		return "redirect:/";

	}

	@RequestMapping("cart/remove/{id}")
	public String removeCart(@PathVariable("id") int id, ModelMap model) throws Exception {
		log.debug("Start: method removeCart");

		try {
			cartDAO.delete(id);
			model.addAttribute("message", "Successfully removed");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		log.debug("End: method removeCart");
		return "redirect:/myCart";
	}

	@RequestMapping("cart/edit/{id}")
	public String editCart(@PathVariable("id") String id, Model model) {
		log.debug("Start: method editCart");
		System.out.println("editCart");
		model.addAttribute("cart", this.cartDAO.getByUserId(id));
		model.addAttribute("listCarts", this.cartDAO.list());
		log.debug("End: method editCart");
		return "cart";
	}

	@RequestMapping("/checkOut")
	public String checkout(Model model,HttpSession session) {
		log.debug("Start: method editCart");
		System.out.println("editCart");
		model.addAttribute("userClickedCheckOut", true);
		UserDetails user = (UserDetails) session.getAttribute("user");
		log.info("\n*************\nuserID is {}\n*************\n", user.getId());
		
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", categoryDAO.list());
		cart = cartDAO.getByUserId(user.getId());
		model.addAttribute("cart", cart);
		model.addAttribute("cartList", cartDAO.userCartList(user.getId()));
		model.addAttribute("totalAmount", cartDAO.getTotalAmount(user.getId()));
		log.debug("End: method editCart");
		return "Home";
	}
	
	@RequestMapping("checkOut/confirm")
	public String confirm(Model model,HttpSession session) {
	UserDetails user = (UserDetails) session.getAttribute("user");
		cartDAO.checkOut(user.getId());
		return "Home";
	}
}
	

