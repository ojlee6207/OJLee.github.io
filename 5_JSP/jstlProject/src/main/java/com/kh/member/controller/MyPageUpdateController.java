package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.member.service.MemberService;

/**
 * Servlet implementation class MyPageUpdateController
 */
@WebServlet("/update.me")
public class MyPageUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		String[] interestList = request.getParameterValues("interest");
		
		String interest = "";
		if(interestList != null) {
			interest = String.join(",", interestList);
		}
		
		Member updateMember = new Member(userId, userName, phone, 
										email, address, interest);	
		
		// 해당 정보를 전달하여 DB에 변경하도록 요청
		Member member = new MemberService().updateMember(updateMember);
		// 정보 변경 실패 시 -> member : null
		if(member == null) {
			// 에러 메세지와 함께 에러 페이지 출력
			request.setAttribute("errorMsg", "회원정보 변경에 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		} else {
			// 회원정보 변경 성공 => member 변경 => session에 변경된 정보로 업데이트
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);
			session.setAttribute("alertMsg", "회원정보 변경 성공");
			
			// 마이 페이지 url 재요청 : "/jsp/myPage.me" 재요청
			response.sendRedirect(request.getContextPath()+"/myPage.me");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
