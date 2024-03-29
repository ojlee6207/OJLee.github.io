package com.kh.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.notice.model.vo.Notice;
import com.kh.notice.service.NoticeService;

/**
 * Servlet implementation class NoticeUpdateController
 */
@WebServlet("/update.no")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		// 2) 전달된 데이터 뽑아오기, 로그인 유저 정보 뽑아오기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int noticeNo = Integer.parseInt(request.getParameter("num"));

		// 3) 요청 처리 => update, DML
		Notice notice = new Notice();
		notice.setNoticeTitle(title);
		notice.setNoticeContent(content);
		notice.setNoticeNo(noticeNo);
		// 추가 (insert) -> DML -> int
		int result = new NoticeService().updateNotice(notice);
		
		// 4) 결과에 따라
		// 성공
		if ( result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 공지사항이 변경되었습니다.");
			response.sendRedirect(request.getContextPath()+"/detail.no?num="+noticeNo);
		// 실패
		} else {
			request.setAttribute("errorMsg", "공지사항 변경에 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
