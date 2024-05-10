package org.jsp.HomeControllerDao;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class HomeController {
	
	
	
	@RequestMapping(value="/open-home")
	public String openHomePage( Model model) {
		
		System.out.println("home page controlled");
		model.addAttribute("username","virat");
		
		return "home";

	}
	@RequestMapping(value = "/open-view")
	public String openview(@RequestParam(name = "view") String view) {
		return view;
	}

	@RequestMapping("/sum")
	public String findSum(@RequestParam(name="num1") int num1, @RequestParam(name="num2") int num2, Model model){
		System.out.println("sum of numbers activated!");
		model.addAttribute("result",num1+"+"+num2+"="+(num1+num2));
		return "print";
	}
	
	@RequestMapping("/diff")
	public String findDiff(@RequestParam(name="num1")int num1, @RequestParam(name="num2")int num2, Model model) {
		System.out.println("Differense between two number:");
		model.addAttribute("result", num1+"-"+num2+"="+(num1-num2));
		return "print";
	}
	
	@RequestMapping("/product")
	public String findProduct(@RequestParam(name="num1")int num1, @RequestParam(name="num2")int num2, Model model) {
		System.out.println("Differense between two number:");
		model.addAttribute("result", num1+"x"+num2+"="+(num1*num2));
		return "print";
	}
	@RequestMapping("/quotient")
	public String findQuotient(@RequestParam(name="num1")int num1, @RequestParam(name="num2")int num2, Model model) {
		System.out.println("Differense between two number:");
		model.addAttribute("result", num1+"/"+num2+"="+(num1/num2));
		return "print";
	}
}
