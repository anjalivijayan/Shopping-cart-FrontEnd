package com.niit.shoppingcart;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

/*import javax.servlet.http.HttpSession;*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.UserDetails;
import com.niit.shoppingcart.util.FileUtil;
import com.niit.shoppingcart.util.Util;



@Controller
public class HomeController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	
	@NotNull
	@Autowired(required = true)
	private ProductDAO productDAO;
	List<Product> allproducts;
	
	@NotNull
	@Autowired(required = true)
	private CategoryDAO categoryDAO;
	
	@NotNull
	@Autowired(required = true)
	private SupplierDAO supplierDAO;
	
	@Autowired
	UserDetails userDetails;

	
	
	
	@NotNull
	@Autowired
	
	UserDetailsDAO userDetailsDAO;
	List<UserDetails> allu;
 
	
	
	@RequestMapping("/")
	
	public ModelAndView onLoad(HttpSession session){
		
		log.debug("Start of the method onload");
		ModelAndView mv = new ModelAndView("/Home");
		Category category = null;
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());
		
		mv.addObject("ROLE_ADMIN", "true");
		//mv.addObject("userClickedHome", "true");
		log.debug("End: method onLoad");
		
		
		return mv;
		
		
	}
	
	
	
	
@RequestMapping("/test")
public String test(){
	
	return "test";
}
	/*@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv= new ModelAndView("Home");
		mv.addObject("message", "Thank you for visiting the url");
		List<Category> categoryList = categoryDAO.list();
		mv.addObject("categoryList", categoryList);
//		System.out.println("size" + categoryList.size());
		
		return mv;
		
	}*/
	
	/*/@RequestMapping(value = "user/register", method = RequestMethod.GET)
	public ModelAndView registerUser(@ModelAttribute("userDetails") UserDetails userDetails) {
		
		log.info("User object going to be registered has user id: " + userDetails.getId());
		userDetails.setRole("ROLE_USER");
		uDao.save(userDetails);
		ModelAndView mv  = new ModelAndView("redirect:/");
		mv.addObject("successMessage", "You are successfully register");
		
		return mv;
	}*/
	
	
	@RequestMapping(value = "users/register", method = RequestMethod.GET)
	public ModelAndView registerUser(HttpSession session){
		log.debug("Start method register user");
		log.info("User object going to be registered has user id: " + userDetails.getId());
		System.out.println(userDetails.getId()+"000000000000000000000");
		userDetails.setRole("ROLE_USER");
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		userDetailsDAO.save(userDetails);
		ModelAndView mv = new ModelAndView("redirect:/");
		mv.addObject("SuccessMessage", "You are successfully registered");
		log.debug("End method register user");
		return mv;
		
	}

/*@RequestMapping(value = "users/register", method = RequestMethod.GET)
public ModelAndView registerUser(HttpSession session) {
	log.debug("Start: method registerUser");
	log.info("User object going to be registered has user id: " + userDetails.getId());
	userDetails.setRole("ROLE_USER");
	UserDetails userDetails =  (UserDetails) session.getAttribute("userDetails");
	userDetailsDAO.saveOrUpdate(userDetails);
	ModelAndView mv = new ModelAndView("redirect:/");
	mv.addObject("successMessage", "You are successfully register");

	log.debug("End: method registerUser");
	return mv;
}
	*/
	
	/*@RequestMapping("/allproducts")
	public void getallproducts()
	{
		allproducts=productDAO.list();
		for(Product p:allproducts)
		{
			System.out.println(p.getName());
		}
	}*/
	
	@RequestMapping("/registerHere")
	public ModelAndView register(@ModelAttribute("userDetails")UserDetails ud )
	{
	ModelAndView mv= new ModelAndView("Registration");
	mv.addObject("isUserClickedRegisterHere", true);
	return mv;
	}
	
	/*@RequestMapping("/UserList")
	public ModelAndView Userlist()
	{
		ModelAndView mv= new ModelAndView("UserList");
		allu=userDetailsDAO.list();
		mv.addObject("userList", allu);
		return mv;
	}*/
	
	
	@RequestMapping("/loginHere")
	public ModelAndView login()
	{
		ModelAndView mv= new ModelAndView("Home");
		mv.addObject("isUserClickedLoginHere", true);

		return mv;
	}
	
	private String path = "D:\\shoppingcart\\images\\";
	
	@RequestMapping(value = "productadd")
	public String addProduct(@ModelAttribute("product") Product product) {
		
		
		Category category = categoryDAO.getByName(product.getName());
		categoryDAO.save(category); 
        
        System.out.println("ghi");
		Supplier supplier = supplierDAO.getByName(product.getName());
		supplierDAO.save(supplier);
		
		//product.setCategory(category);
		//product.setSupplier(supplier);
		
		  System.out.println("ghi1");
		//product.setCategory_ID(category.getId());
		//product.setSupplier_ID(supplier.getId());
		  
		  String newID = Util.removeComma(product.getId());
		  System.out.println("ghi2");
		productDAO.save(product);
		MultipartFile file = product.getImage();
		
		FileUtil.upload(path, file,"id"+product.getId()+".jpg");
		  System.out.println("ghi3");
		return "redirect:/manageProducts";
		// return "redirect:/uploadFile";

	}
	
	
	
	

	@RequestMapping("productedit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		System.out.println("editProduct");
		model.addAttribute("product", this.productDAO.get(id));
		System.out.println("edit1");
		model.addAttribute("listProducts", this.productDAO.list());
		System.out.println("edit2");
		model.addAttribute("categoryList", this.categoryDAO.list());
		System.out.println("edit3");
		model.addAttribute("supplierList", this.supplierDAO.list());

		return "product";
	}
	
	@RequestMapping("product/remove/{id}")
	public String removeProduct(@PathVariable("id") String id, ModelMap model) throws Exception {
		log.debug("Start: method removeProduct");

			

		try {
			
			String i=id.replace(",","");
			Product product = productDAO.get(id);
			System.out.println("dssssssssssss"+product);
			productDAO.delete(product);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		
		
		log.debug("End: method removeProduct");
		return "redirect:/product";
	}


}
