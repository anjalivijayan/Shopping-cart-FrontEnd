package com.niit.shoppingcart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.util.Util;


@Controller
public class SupplierController {
	
	
private static Logger log = LoggerFactory.getLogger(CategoryController.class) ;
	
	@Autowired
	
	private SupplierDAO supplierDAO;
	
	@Autowired
	
	private Supplier supplier;
	
	@RequestMapping(value= "/supplier", method=RequestMethod.GET)
	
	public String listSupplier(Model model){
		
		log.debug("Starting of the method listsupplier");
		model.addAttribute("supplier", supplier);
		model.addAttribute("categoryList",supplierDAO.list());
		log.debug("End of the method listsupplier");
		return "supplier";
	}
	
	@RequestMapping(value= "/supplier/add", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier")Supplier supplier)
	{
		log.debug("Start of the method addsupplier");
		
		String newid = Util.removeComma(supplier.getId());
		ModelAndView mv= new ModelAndView();
		if(supplierDAO.get(supplier.getId())==null)
		{
			supplierDAO.save(supplier);
			
		}
		else
		{
			mv.addObject("ErrorMessage", "The record exist with this id" +supplier.getId());
		}
		
		log.debug("End of the method ");
		return "redirect:/supplier";
	}
	
	@RequestMapping("supplier/remove/{id}")
	
	public ModelAndView deleteSupplier(@PathVariable("id") String id)throws Exception{
		
		supplier=supplierDAO.get(id);
		ModelAndView mv = new ModelAndView("supplier");
		if(supplier==null)
		{
			mv.addObject("errormsg","Could not delete the supplier");
			
		}
		else
		{
			supplierDAO.delete(supplier);
		}
		
		String msg= "Successfully done the operation";
		
		return mv;
	}
	@RequestMapping("supplier/edit/{id}")
	public String editSupplier(@PathVariable("id") String id, Model model) {
		System.out.println("editSupplier");
		supplier = supplierDAO.get(id);
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		// model.addAttribute("supplier", supplierDAO.get(id));
		// model.addAttribute("supplierList",supplierDAO.list());
		return "redirect:/supplier";
}
	
	
	

}

	
	
	
	
	


