package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class JqAjax2Controller
 */
@WebServlet("/jqAjax2.do")
public class JqAjax2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjax2Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.valueOf(request.getParameter("age"));
		// 1. 문자열 하나의 데이터로 응답
		/*
			String responseData = "응답 데이터 : 이름: "+name+ ", 나이 : "+age;
			응답 전 : 데이터에 한글이 포함이면 인코딩 설정
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(responseData);

		// 2. 
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(name);
			response.getWriter().print(age);
		// 위와 같이 응답 시 success:function의 매개변수로 하나의 문자열 전달

		// 3. 객체 형태로 응답
		/**
		 * 여러 개의 데이터를 응답하고자 할 때, "JSON" 형태로 응답(JavaScript Object Notation: 자바스크립트 객체 표기법)
		 * - ajax 통신을 할 때 자주 사용되는 포맷 중 하나
		 * 
		 * > 자바스크립트 배열 객체 : [value1, value2, value3] => JSONArray
		 * > 자바스크립트 일반 객체 : { key1:value1, key2:value2 } => JSONObject
		 * 
		 *  - 라이브러리 추가 필요! json-simply-x.x.x.jar
		 */
		// * 배열 객체(JSONArray)로 응답 --> ArrayList와 유사
		/*
		JSONArray jsonArr = new JSONArray();// 빈 배열 생성 : []
		jsonArr.add(name);					// 이름에 대한 데이터를 배열에 추가: ["홍길동"]
		jsonArr.add(age);					// 나이에 대한 데이터를 배열에 추가: ["홍길동", 20]
		
		response.setContentType("text/html; charset=UTF-8"); // => text/html 시 응답 데이터가 String 타입으로 전달
		response.setContentType("application/json; charset=UTF-8"); // => mime type을 JSON형식으로 응답할 때(application/json)
		response.getWriter().print(jsonArr);
		*/
		// * 일반객체(JSONObject)로 응답 --> HashMap과 유사
		JSONObject jsonObj = new JSONObject();	// 빈 객체 생성 {}
		jsonObj.put("name", name);				// 이름 데이터 키:value 형태로 추가 {name:"홍길동"}
		jsonObj.put("age", age);				// 나이에 대한 데이터 키:value { name:"홍길동", age:20 }
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jsonObj);
	}
}
