package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/test.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// + 인코딩 설정
		request.setCharacterEncoding("utf-8");

		// 자바(Servlet) 코드 변경 시 톰캣 서버 재시작 필요 
		// + 콘솔창에 컨텍스트가 로드된 경우 재시작 필요 X
		
		// Get 방식으로 요청 시 doGet 메소드가 자동으로 호출됨
		System.out.println("Get 요청이 들어옴!");
		
		/*
		 * 첫번째 매개변수인 request는 요청 시 전달되는 내용들이 담겨져 있음.(사용자 입력 값, 요청 전송방식, 요청한 곳의 IP 등)
		 * 두번째 매개변수인 response는 요청에 대한 처리 후 응답 시 사용되는 객체.
		*/
		// Get 요청 시 전달된 값들을 확인
		// * 전달된 모든 key(파라미터) 확인 : getParameterNames();
		/*
		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()) {
			String param = params.nextElement();
			System.out.println(param);
		}
		*/
		
		// * 하나씩 확인하고자 할 때 => getParameter(Key명) : 해당value값
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("age"));
		System.out.println(request.getParameter("address"));
		System.out.println(request.getParameter("height"));
		System.out.println(request.getParameter("food"));
		
		System.out.println(request.getParameter("kkk")); // 해당 key에 맞는 데이터가 없다면 'null' 리턴
		
		// 응답을 보내보기
		// + setContentType : 응답 데이터 타입; 인코딩
		//		- 인코딩: charset=utf-8;
		response.setContentType("text/html;charset=utf-8");
//		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("굿 잡!");
		pw.close();

		
//		System.out.println(request.getParameterNames()); 
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
