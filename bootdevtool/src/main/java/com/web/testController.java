package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

	@RequestMapping("/test")
	@ResponseBody
	public String handler() {
		int a=10;
		int b=40;
		int sum=a+b;
		return "sum is"+sum;
	}
}
