package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.vo.Member;

/**
 * Servlet implementation class JqAjax3Controller
 */
@WebServlet("/jqAjax3.do")
public class JqAjax3Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjax3Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Member m = new MemberService().selectMember(userNo);
//		=> m 변수에 멤버 정보가 담겨져 있을 것.
		int userNo = Integer.valueOf(request.getParameter("userNo"));
		Member m = new Member(userNo, "홍길동", 40, "남자");
		
//		response.getWriter().print(m);
//		=> vo 객체를 전달하고자 할 경우,
//			JSONObject { key:value, key:value } 타입으로 전달해야 함
		/*
		JSONObject jsonObj = new JSONObject();		// {}
		jsonObj.put("userNo", m.getUserNo());		// {userNo:11}
		jsonObj.put("userName", m.getUserName());	// {userNo:11, userName:"홍길동"}
		jsonObj.put("age", m.getAge());				// {userNo:11, userName:"홍길동", age:40}
		jsonObj.put("gender", m.getGender());		// {userNo:11, userName:"홍길동", age:40, gender:남}
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jsonObj);
		*/
		// 위 작업을 간단히 : 라이브러리 (GSON: Google JSON)
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new Gson();
		// Gson객체명.toJson(응답할vo객체, 응답할_스트림);
		gson.toJson(m, response.getWriter());
		/*
		 * Gson을 통해 vo객체를 응답하는 경우 JSONObject 형태로 전달
		 * 이때, key값은 vo객체의 필드명으로 지정되어 전달
		 * 
		 * ArrayList / 자바 배열을 응답하는 경우 JSONArray로 전달
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
