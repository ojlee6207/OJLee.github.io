package com.kh.home.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Object loginUser = request.getSession().getAttribute("loginUser");
		
		if (loginUser == null) {
			response.sendRedirect("/");
			return false;		// controller로 가지 않고 위의 처리 진행
		} else {
			return true;		// controller로 가서 기존대로 진행	
		}
		
	}

	
}
