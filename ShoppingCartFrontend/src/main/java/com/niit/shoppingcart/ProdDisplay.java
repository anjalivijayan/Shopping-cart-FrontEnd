package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;

public class ProdDisplay {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("/Table")
	public ModelAndView table()
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedTable","true");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping("/Chair")
	public ModelAndView chair()
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedChair","true");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping("/Bed")
	public ModelAndView bed()
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedBed","true");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping("/Lamp")
	public ModelAndView lamp()
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedLamp","true");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}
	
	
}

	