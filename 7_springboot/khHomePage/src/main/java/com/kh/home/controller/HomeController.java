package com.kh.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String initPage() {
		return "index";
	}
	
	@RequestMapping("/success")
	public String loginSuccess() {
		return "success";
	}
	
	@RequestMapping("/failure")
	public String loginFailure() {
		return "failure";
	}
	
	@ResponseBody
	@RequestMapping("/test")
	public String testPage() {
		return "<h2>테스트 페이지 입니다(로그인 후 접근 가능)</h2>";
	}
	
	// 구글 서버로 부터 요청된 uri (redirect_uri 지정)
	@RequestMapping("/login/oauth/google")
	public String googleLoginResult(@RequestParam(value="code", defaultValue="")String code, 
									@RequestParam(value="error", defaultValue="") String error, 
									HttpSession session) {
		if (code.isEmpty()) {	// 인증 실패
			session.setAttribute("errorMsg", error);	// request에 에러 메세지 저장 
			return "redirect:/failure";				// 로그인 실패 페이지로 재요청
		} else {			// 인증 성공
			session.setAttribute("loginUser", code);		// 세션영역에 인증 토큰 저장
			return "redirect:/success";				// 로그인 성공 페이지로 재요청
		}
	}
}
