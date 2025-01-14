package com.kh.grdPrj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitController {
	
	@RequestMapping("/")
	public String initPage(Model model) {
		model.addAttribute("test", "gradle 테스트중입니다");
		return "index";
	}
}
