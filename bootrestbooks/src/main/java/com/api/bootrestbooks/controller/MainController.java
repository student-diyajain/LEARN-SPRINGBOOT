package com.api.bootrestbooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class MainController {
    
@RequestMapping(value="/home",method=RequestMethod.GET)
@ResponseBody
public String handler(){
return "main controller works";
}




@GetMapping("/page")
@ResponseBody
public String getMethodName() {
    return "get mapping anotation works";
}





}
