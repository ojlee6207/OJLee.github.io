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
//		request.setCharacterEncoding("utf-8");

		// 자바(Servlet) 코드 변경 시 톰캣 서버 재시작 필요 
		// + 콘솔창에 컨텍스트가 로드된 경우 재시작 필요 X
		// + Servers 탭에서 서버 상태가 [xxx, Restart]와 같이 표기시 재시작 필요
		
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
		
		// * 하나씩 확인하고자 할 때 => getParameter(Key명) : 해당value값(String)
		/* 240306
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("age"));
		System.out.println(request.getParameter("address"));
		System.out.println(request.getParameter("height"));
		System.out.println(request.getParameter("food"));
		
		System.out.println(request.getParameter("kkk")); // 해당 key에 맞는 데이터가 없다면 'null' 리턴
		*/
		
		/*
		 *	요청 시 전달된 데이터를 처리(확인)메소드
		  	1) request.getParameter("Key값") : String(해당 value)
		  	2) request.getParameterValues("key값") : String[] (해당 value값들)
		 */
		
		String name = request.getParameter("name"); // "홍길동"
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		double height = Double.parseDouble(request.getParameter("height"));
		
		// checkbox로 선택된 값 처리
		String[] foods = request.getParameterValues("food");	// [한식,중식,...]
		
//		System.out.println("이름: "+name);
		System.out.printf("이름: [%s]\n", name);
		System.out.printf("성별: [%s]\n", gender);
		System.out.printf("나이: [%d]\n", age);
		System.out.printf("주소: [%s]\n", address);
		System.out.printf("키: [%.1f]\n", height);
		
		if (foods == null) {
			System.out.println("좋아하는 음식 없음");
		} else {
			// 문자열과 함께 출력하려고 했으나 제대로 출력되지 않음
//			System.out.println("좋아하는 음식 : " + foods);
			
			// String.join을 사용하여 배열 내의 값을 특정 구분자를 기준으로 출력
			// 두번째 전달값이(배열) null이면 nullPointerException 발생
			System.out.println("좋아하는 음식 : " + String.join("/",foods));
		}
		// ----------
				
		/*
		// 응답을 보내보기
		// + setContentType : 응답 데이터 타입; 인코딩
		//		- 인코딩: charset=utf-8;
		response.setContentType("text/html;charset=utf-8");
//		response.setCharacterEncoding("utf-8"); // POST방식 인코딩
		PrintWriter pw = response.getWriter();
		pw.println("굿 잡!");
		pw.close();
		*/
		
		// 요청이 들어오면 전달된 데이터를 가지고 처리 진행(db, ...)
		// => service 메소드 호출 > Dao 호출 > DB sql 실행

		// 요청에 대한 처리가 완료되었다고 가정 후 응답페이지 작성하여 전송
		// "Java" 코드 내에 사용자가 보게 될 응답페이지(HTML) 작성
		// 장점: 반복문이나 조건문, 활용할 수 있는 메소드를 사용
		// 단점: 불편하고 복잡한 작업, HTML 내용을 수정 시 자바코드를 변경한 것이므로 서버 재시작 필요
		
		// * Response 객체를 통해서 사용자에게 html 페이지 전달
		
		// 1) 출력할 내용의 문서 형태와 문자셋(인코딩)을 설정
		//    response.setContentType("문서형태;charset=문자셋(인코딩)");
		response.setContentType("text/html;charset=utf-8");

		// 2) 요청한 곳으로 스트림 생성(클라이언트와의 통로 생성)
		// response.getWriter() 사용
		PrintWriter out = response.getWriter();
		
		// 3) 생성된 스트림을 통해 응답페이지(html)를 한줄씩 출력
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		
		out.println("<head>");
		
		out.println("<style>");
		out.println("h2 {color:red}");
		out.println("#name {color:orange}");
		out.println("#gender {color:yellow}");
		out.println("#age {color:green}");
		out.println("#address {color:blue}");
		out.println("#height {color:navy}");
		out.println("li {color:purple}");
		out.println("</style>");
		
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h2>응답 결과 페이지</h2>");
//		out.println("<span id='name'>"+ name + "</span>");
		out.printf("<span id='name'>%s</span>님의 입력정보<br> ", name);
		
		out.print("성별은 ");
		if(gender == null) {
			out.println("선택하지 않았습니다.");
		} else {
			out.printf("<span id='gender'>%s</span>입니다.<br>", gender);
		}
		
		out.printf("나이는 <span id='age'>%s</span>입니다.<br>", age);
		
		out.printf("거주지는 <span id='address'>%s</span>입니다.<br>", address);
		
		out.printf("키는 <span id='height'>%s</span>입니다.<br>", height);
		
		out.println("<ol>");
		out.printf("좋아하는 음식은 ");
		if(foods == null) {
			out.println("없습니다.");
		} else {
			for(int i=0; i<foods.length; i++) {
				out.println("<li>"+foods[i]+"</li>");
			}
		}
		out.println("</ol>");
		
		out.println("</body>");
		
		out.println("</html>");
		
		// 화면에 표시가 잘 안 될 때
		out.flush();
		
		out.close();
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
