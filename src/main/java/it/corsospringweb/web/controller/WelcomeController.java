package it.corsospringweb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class WelcomeController {

	@ResponseBody 
	@RequestMapping("/")
	public String welcome() {
		return "Welcome!";
	}
	@ResponseBody 
	@RequestMapping("/ByeBye")
	public String goodbye() {
		return "Goodbye!";
	}
}
