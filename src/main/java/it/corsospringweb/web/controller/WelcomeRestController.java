package it.corsospringweb.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class WelcomeRestController {

	//ciao
	@ResponseBody
	@RequestMapping("/welcome")
	public String welcome() {
		return "{message:\"welcome\"}";
	}

	@ResponseBody
	@RequestMapping("/goodbye")
	public String goodbye() {
		return "{message:\"goodbye\"}";
	}
	
	@ResponseBody
	@RequestMapping(value = "/goodbye", method = RequestMethod.GET, params = {"nome=MyApp", "version=1.0"})
	public String welcomeParams() {
		return "{message:\"goodbye with params\"}";
	}
	
	@ResponseBody
	@RequestMapping(value = "/goodbyeFunzionante", method = RequestMethod.GET, params = {"nome=MyApp", "version=1.0"})
	public String welcomeParamsFunzionante() {
		System.out.println("ciao");
		return "{message:\"goodbye with params\"}";
	}
	

}
