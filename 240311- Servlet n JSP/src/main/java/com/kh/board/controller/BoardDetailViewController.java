package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;

/**
 * Servlet implementation class BoardDetailViewController
 */
@WebServlet("/detail.bo")
public class BoardDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("bnum"));
		
		// 서비스 객체에게 해당 게시글 번호 전달
		// 조회수 업데이트, 해당 게시글 정보 조회 반환
		Board b = new BoardService().selectDetailBoard(boardNo);
		Attachment at = new BoardService().selectAttachment(boardNo);
		
		// request 객체에 조회된 정보를 담아 응답함
		// boardDetailView.jsp 응답
		// 게시글 정보 조회 실패 시 에러 페이지 응답
		if (b != null) {
			request.setAttribute("board", b);
			request.getRequestDispatcher("views/board/boardDetailView.jsp").forward(request, response);
		} else { 
			request.setAttribute("errorMsg", "게시글 조회에 실패했습니다.");
			request.getRequestDispatcher("views/common.errorPage.jsp");
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
