package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/test2.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메소드 실행!");
	
		// 요청 시 전달되는 값들은 request의 parameter 영역에 있음
		
		// POST의 경우 데이터 처리 "전"에 인코딩 필요!
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");	// "입력값" | ""
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		double height = Double.parseDouble(request.getParameter("height"));
		
		String[] foods = request.getParameterValues("food");	// [한식,중식,...] | [null]
		
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("address : " + address);
		System.out.println("height : " + height);
		if(foods==null) {
			System.out.println("foods : 선택항목 X");
		} else {
			System.out.println("foods : " + String.join("-", foods));
		}
	
		// --------------
		
		// 요청 처리 : > Service > Dao > DB 처리
		
		// 순수 servlet 방식 : Java 코드 내에 html 작성
		// JSP (Java Server Page) 방식 : html 내에 Java코드 작성
		
		// 응답 페이지를 만드는 과정을 jsp에게 맡김
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 서블릿은 REST API 구현 전 버전으로 단순히 서블릿 구현이면 GET, POST를 동일하게 처리
		 * GET, POST를 구분하여 처리하는 경우도 별도로 코드 작성은 가능 
		*/
		System.out.println("doPost 메소드 실행!");
		doGet(request, response);
	}

}
