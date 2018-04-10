/**
 * 
 */
package com.demographics.application.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mahesh S
 *
 */

@Controller
public class WebController {

	 @RequestMapping("/a")
	    String home(ModelMap modal) {
	        modal.addAttribute("title","CRUD Example");
	        return "index";
	    }
	
}
