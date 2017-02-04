package com.myretail;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class HomeController {

	
	@RequestMapping("/")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
      
        return "hello";
    }
}
