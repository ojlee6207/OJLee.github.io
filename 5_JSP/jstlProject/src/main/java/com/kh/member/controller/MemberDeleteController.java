package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.member.service.MemberService;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/deleteMember.me")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
				
		int result = new MemberService().deleteMember(userId, userPwd);
		
		HttpSession session = request.getSession();

		if(result > 0) {

			// 성공 메시지를 띄우기 위한 데이터 설정
			session.setAttribute("alertMsg", 
					"성공적으로 탈퇴되었습니다. 그동안 이용해주셔서 감사합니다..");
			// 회원 정보를 세션에서 제거
			session.removeAttribute("loginUser");
			// 홈 url 재요청 : "/jsp" 재요청
			response.sendRedirect(request.getContextPath());

			
		} else {
			session.setAttribute("alertMsg", "회원탈퇴 실패했습니다.");
			// 마이페이지로 응답
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
