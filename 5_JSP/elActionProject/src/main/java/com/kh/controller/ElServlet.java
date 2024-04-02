package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.vo.Person;

/**
 * Servlet implementation class ElServlet
 */
@WebServlet("/el.do")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * * 데이터를 담을 수 있는 JSP 내장 객체 종류
		 * 	1. ServletContext (application scope)
		 *		- 한 애플리케이션 당 단 1개만 존재하는 객체	
		 *		- 이 영역에 데이터를 담으면 애플리케이션 전역에서 사용 가능
		 *		- 공유 범위가 큼 (jsp/servlet/java)
		 *
		 *	2. HttpSession (session scope)
		 *		- 한 브라우저 당 1개 존재하는 객체 (크롬, 엣지, 사파리, 라이어폭스...)
		 *		- 이 영역에 데이터를 담으면 jsp/servlet 단에서 사용 가능
		 *		- 공유 범위가 다소 제한적임 (java 단에서는 사용 불가)
		 *
		 *	3. HttpServletRequest (request scope)
		 *		- 요청할 때마다 매번 생성되는 객체
		 *		- 이 영역에 데이터를 담으면 해당 request 객체를 포워딩 받는 jsp에서만 사용 가능
		 *		- 공유 범위가 응답된 jsp에서만 가능
		 *
		 *	4. PageContext (page scope)
		 *		- jsp 마다 존재하는 객체
		 *		- 공유 범위가 가장 작음 (해당 페이지에서 담고 해당 페이지에서 사용)
		 *
		 *	위의 객체들에 데이터를 담고자 할 때,
		 *		.setAttribute("키값", 담고자_하는_데이터)
		 *
		 *			  데이터를 꺼내고자 할 때,
		 *		.getAttribute("키값") : 담겨있는_데이터 (Object)
		 *
		 *			  데이터를 삭제하고자 할 때,
		 *		.removeAttribute("키값")
		 */
		// request scope에 데이터 담기
		request.setAttribute("classRoom", "L강의장");
		request.setAttribute("student", new Person("홍길동", 33, "남자"));
		
		// session scope에 데이터 담기
		HttpSession session = request.getSession();
		session.setAttribute("academy", "KH교육원");
		session.setAttribute("teacher", new Person("임수진", 20, "여자"));
		
		// request scope와 session scope에 동일한 키값으로 데이터 담기
		request.setAttribute("scope", "request");
		session.setAttribute("scope", "session");
		
		// application scope에 동일한 키값으로 데이터 담기
		ServletContext application = request.getServletContext();
		application.setAttribute("scope", "application");
		
		request.getRequestDispatcher("views/1_EL/01_el.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
