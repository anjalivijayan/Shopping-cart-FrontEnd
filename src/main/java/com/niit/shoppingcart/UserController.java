package com.niit.shoppingcart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	
	UserDetailsDAO userDetailsDAO;
	
	@Autowired
	
	Category category;
	
	@Autowired
	
	CategoryDAO categoryDAO;
	
	@Autowired
	
	UserDetails userDetails;
	
	@RequestMapping("/Login")
	public ModelAndView login(@RequestParam(value = "name")String id,@RequestParam(value="password") String password, HttpSession session){
		
		log.debug("Starting of the method login");
		log.info("userID is {}  password is {}", id, password);
		
		ModelAndView mv = new ModelAndView("Home");
		
		System.out.println("abc");
		String msg;
		
		boolean user;
		boolean isValidUser =userDetailsDAO.isValidUser(id, password);
		if (isValidUser == true) {
			userDetails = userDetailsDAO.get(id);
			session.setAttribute("loggedInUser", userDetails.getName());
		
		
			
			if(userDetails.getRole().equals("ROLE_ADMIN")){
				
		
				mv= new ModelAndView("AdminHome");
				
			}else{
				System.out.println("efg");
				session.setAttribute("name", userDetails.getName());
				session.setAttribute("UserID", userDetails.getId());
			}
			
			
			
		}
		
		
		return mv;
		
	}
	
	
	
	
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("/Home");
		session.invalidate();
		session = request.getSession(true);
		//session.setAttribute("category", category);
		//session.setAttribute("categoryList", categoryDAO.list());
	
		mv.addObject("logoutMessage", "You successfully logged out");
		mv.addObject("loggedOut", "true");
	
		return mv;
	 }
	

}
