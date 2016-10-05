package com.niit.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.util.FileUtil;
import com.niit.shoppingcart.util.Util;

public class ProductController {

	@Autowired(required = true)
	private ProductDAO productDAO;

	@Autowired(required = true)
	private CategoryDAO categoryDAO;

	@Autowired(required = true)
	private SupplierDAO supplierDAO;
	
	
	
	
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String listProducts(Model model) {
		
		
		model.addAttribute("isAdminClickedProducts", "true");
		model.addAttribute("product", new Product());
		model.addAttribute("category", new Category());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplierList", this.supplierDAO.list());
		return "Home";
	}

	// For add and update product both
	
	
	

	@RequestMapping("product/remove/{id}")
	public String removeProduct(@PathVariable("id") String id, ModelMap model) throws Exception {

		try {
		
		Product product= productDAO.getByName(id);
			
			productDAO.delete(product);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		
		return "redirect:/manageProducts";
	}

	@RequestMapping(value = "product/get/{id}")
	public String getSelectedProduct(@PathVariable("id") String id, Model model,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("selectedProduct", productDAO.get(id));
		return "redirect:/backToHome";

	}

	@RequestMapping(value = "/backToHome", method = RequestMethod.GET)
	public String backToHome(@ModelAttribute("selectedProduct") 
	        final Object selectedProduct, final Model model) {

		model.addAttribute("selectedProduct", selectedProduct);
		//model.addAttribute("categoryList", this.categoryDAO.list());

		return "/Home";
	}


}

	
	
	
	

