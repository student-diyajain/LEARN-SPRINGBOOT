package com.practise.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MyController {
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String about(Model m) {
		System.out.println("inside about handler!");
		m.addAttribute("name","diya jain");
		m.addAttribute("currentDate",new Date());
		return "about";
	}
	
	@RequestMapping("/iterate")
	public String iterateHandler(Model m) {
		System.out.println("inside iterate handler!");
		List<String> list=List.of("ankit","laxmi","karan","diya");
		m.addAttribute("names",list);
		return "iterate";
	}
	
	@GetMapping("/condition")
	public String conditionHandler(Model m) {
		System.out.println("inside condition handler!");
		m.addAttribute("isActive",false);
		m.addAttribute("gender","M");
		List<String> list=List.of("ankit","laxmi","karan","diya");
		m.addAttribute("names",list);
		return "condition";
	}

	@RequestMapping("/service")
	public String serviceHandler(Model m) {
		m.addAttribute("title","science");
		m.addAttribute("subtitle","physics");
		return "service";
	}
	
	@RequestMapping("/newa")
	public String newAboutHandler() {
		return "newAbout";
	}
	
	@RequestMapping("/newc")
	public String newContactHandler() {
		return "newContact";
	}
}
