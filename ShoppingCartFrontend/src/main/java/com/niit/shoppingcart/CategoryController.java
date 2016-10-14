package com.niit.shoppingcart;

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
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.util.Util;

@Controller
public class CategoryController {
	
	private static Logger log = LoggerFactory.getLogger(CategoryController.class) ;
	
	@Autowired
	
	private CategoryDAO categoryDAO;
	
	@Autowired
	
	private Category category;
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String listCategories(Model model) {
		log.debug("Start of method listCategories");
		model.addAttribute("isAdminClickedCategories", "true");
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.list());
		log.debug("End of method listCategories");
		return "Home";
}
	
	@RequestMapping(value= "/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category")Category category)
	{
		log.debug("Start of the method addcategory");
		
		String newID = Util.removeComma(category.getId());
		category.setId(newID);
		ModelAndView mv= new ModelAndView();
		if(categoryDAO.get(category.getId())==null)
		{
			categoryDAO.saveOrUpdate(category);
			
		}
		else
		{
			mv.addObject("ErrorMessage", "The record exist with this id" +category.getId());
		}
		
		log.debug("End of the method ");
		return "redirect:/categories";
	}
	
	
	
	@RequestMapping(value = "category/remove/{id}")
	public String deleteCategories(@PathVariable("id") String id,ModelMap model) {
		log.debug("Start: method deleteCategories");
		log.info("Category id going to be deleted : " +id);
		try {
			categoryDAO.delete(category);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		
		log.debug("End: method deleteCategories");
		return "redirect:/categories";
	}
	
	@RequestMapping(value = "category/edit/{id}")
	public String editCategories(@PathVariable("id") String id,ModelMap model) {
		log.debug("Start of method editCategories");
		log.info("Category id going to be edited : " +id);
		category=categoryDAO.get(id);
		//categoryDAO.update(category);
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.list());
		log.debug("End of method editCategories");

		return "redirect:/categories";
}
	/*@RequestMapping(value = "category/edit/{name}")
	public String editCategories(@PathVariable("name") String name,ModelMap model) {
		log.debug("Start: method deleteCategories");
		log.info("Category id going to be edited : " +name);
		try {
			categoryDAO.update(category);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		
		log.debug("End: method deleteCategories");
		return "redirect:/categories";
	}
	*/
	
	

}
