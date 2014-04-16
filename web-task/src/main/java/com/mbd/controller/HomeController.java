package com.mbd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Context Page Controller
 */
@Controller
@RequestMapping("/")
public class HomeController {

	/**
	 * Navigates to the home (root) page
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) {
		return "index";
	}

}
