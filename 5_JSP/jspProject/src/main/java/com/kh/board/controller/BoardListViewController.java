package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;
import com.kh.common.model.PageInfo;

/**
 * Servlet implementation class BoardListViewController
 */
@WebServlet("/list.bo")
public class BoardListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 일반 게시글 목록 조회
		
		// -- 페이징 처리 --
		int listCount; 		// 전체 페이지 갯수
		int currentPage;	// 현재 페이지(사용자로부터 요청시 전달될 값)
		int pageLimit;		// 페이지 하단에 표시된 페이징바의 최대 수
		int boardLimit;		// 한 페이지에 표시할 게시글의 최대 갯수
		
		// 위 4개의 데이터로 아래 3개 데이터 추출
		int maxPage;		// 가장 마지막 페이지(총 페이지 수)
		int startPage;		// 페이징바의 시작 번호
		int endPage;		// 페이징바의 마지막 번호
		
		// listCount(전체 게시글 갯수) : DB에 저장된 데이터 갯수 조회
		listCount = new BoardService().selectListCount();
		
		// currentPage(현재 페이지) : 요청 시 전달된 값에서 조회
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		// pageLimit, boardLimit : 10
		pageLimit = 10;	 // 페이징 바의 최대 갯수(단위)
		boardLimit = 10; // 한 페이지에 표시할 게시글 개수(단위)
		
		/**
		 * 	* maxPage : 마지막 번호
		 * 
		 * listCount, boardLimit의 영향
		 * 
		 * ex) 게시글이 10개씩 표시되는 경우
		 * 	listCount		boardLimit		maxPage
		 * 	   100				10			  10
		 *	   101				10			  11
		 *	   110				11			  11
		 * */
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		/**
		 * * startPage : 페이징 바의 시작번호
		 * 
		 * pageLimit, currentPage 데이터의 영향
		 * ex) 페이징 바에 목록이 10개씩 이라면,
		 * 	startPage => 1, 11, 21, 31, ...
		 * 				n *10 +1
		 * 				=> n*pageLimit)+1
		 * */
		startPage = (currentPage-1)/pageLimit * pageLimit +1;
		
		/**
		 * * endPage : 페이징바의 마지막 번호
		 * 
		 * startPage, pageLimit 값에 영향을 받음 (단, maxPage 영향을 받을 수도 있음)
		 * 
		 * */
		endPage = startPage + pageLimit-1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		// 페이징바 관련 객체 com.kh.common.PageInfo 추가
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit
								, maxPage, startPage, endPage);
		ArrayList<Board> list = new BoardService().selectList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/board/boardListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
