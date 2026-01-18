package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/")
	public String getHome()
	{
		System.out.println("UserController.getHome()");
		return "index";
	}

}
