package com.ncee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
	@RequestMapping(value="/index",method={RequestMethod.GET})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		mv.setView(new RedirectView("jinghe.jsp"));
		return mv;
	}
}
