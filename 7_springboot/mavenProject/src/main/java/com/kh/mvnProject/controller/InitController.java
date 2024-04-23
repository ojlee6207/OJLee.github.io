package com.kh.mvnProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitController {
	
	@RequestMapping("/")
	public String initPage(Model model) {
		model.addAttribute("test", "하이하이");
		return "index";
	}
}
