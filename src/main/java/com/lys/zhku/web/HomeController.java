package com.lys.zhku.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = {"/index","/"})
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/subviews/{pathName}/{fileName}", method = RequestMethod.GET)
	public String subviews(@PathVariable String pathName, @PathVariable String fileName) {
		return "subviews/" + pathName +"/"+ fileName;
	}

}
