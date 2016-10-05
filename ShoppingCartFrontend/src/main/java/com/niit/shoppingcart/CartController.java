package com.niit.shoppingcart;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.UserDetails;

public class CartController {
	
	
	Logger log = LoggerFactory.getLogger(CartController.class);

	@Autowired(required = true)
	private CartDAO cartDAO;

	@Autowired(required = true)
	private ProductDAO productDAO;

	@Autowired(required = true)
	private CategoryDAO categoryDAO;

	@Autowired
	private UserDetailsDAO userDetailsDAO;

	@Autowired
	private Cart cart;
	
	

	/*
	 * @RequestMapping(value = "/carts", method = RequestMethod.GET) public
	 * String listCarts(Model model) { model.addAttribute("cart", new Cart());
	 * model.addAttribute("cartList", this.cartDAO.list()); return "cart"; }
	 */

	// For add and update cart both
	@RequestMapping(value = "/cart/add/{id}", method = RequestMethod.GET)
	public String addToCart(@PathVariable("id") String id, HttpSession session) {
		log.debug("Start: method addToCart");
		log.info("\n*************\nproductID is {}\n*************\n", id);
		UserDetails userDetails =(UserDetails) session.getAttribute("userDetails");
		log.info("\n*************\nuserID is {}\n*************\n", userDetails.getId());
		session.setAttribute("cartSize", cartDAO.userCartList(id).size());

		Product product = productDAO.get(id);
		Cart cart = new Cart();
		log.info("\n*************\ncartID is {}\n*************\n", cart.getId());
		cart.setPrice(product.getPrice());
		cart.setProductName(product.getName());
		cart.setProduct(product);
		cart.setQuantity(1);
		cart.setUser(userDetails); // id should keep session and
							// use the same id
		cart.setStatus("available"); //
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
	public String editCart(@PathVariable("id") String user_id, Model model) {
		log.debug("Start: method editCart");
		System.out.println("editCart");
		model.addAttribute("cart", this.cartDAO.getByUserId(user_id));
		model.addAttribute("listCarts", this.cartDAO.list());
		log.debug("End: method editCart");
		return "myCart";
	}

	}



