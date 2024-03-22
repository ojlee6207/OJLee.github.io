package com.kh.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;
import com.kh.common.MyFileRenamePoilcy;
import com.kh.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardInsertController
 */
@WebServlet("/insert.bo")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) POST 요청 : encording
		request.setCharacterEncoding("UTF-8");
		
		// 일반적인 방식이 아닌, multipart/form-data 요청 시 request객체로 추출 불가
		// enctype이 multipart/form-data인 경우 처리 방식
		
		if (ServletFileUpload.isMultipartContent(request)) { // enctype이 multipart/form-data인 경우 true반환)
			//System.out.println("enctype이 multipart/form-data로 들어옴!!");		
			// 파일 업로드를 위한 라이브러리 : cos.jar(com.oreilly.servlety의 약자)
			// www.servlets.com/cos 다운로드 하여 /lib/cos.jar 파일을
			// src/main/webapp/WEB-INF/lib/ 로 복사
			
			// 1. 전달되는 파일을 처리할 작업 내용
			// 		- 파일의 용량 제한
			//		- 파일을 저장시킬 경로
			
			// 파일 용량 제한 : (int maxSize => byte 단위 => 10Mbyte = 1024*1024)
			// byte -> kb -> mb -> gb -> tb (1024배씩 증가)
			int maxSize = 10 * 1024 * 1024;	// 10MB
			
			// 파일 저장 경로 : (String savePath)
			String savePath = request.getSession().getServletContext().getRealPath("/resources/b_upfiles/");
			
//			System.out.println(savePath); (240321)
			
			// 2. 전달된 파일 이름을 변경 및 서버 업로드
			// => HttpServletRequest -> MultipartRequest 변환
			// 	  MultipartRequest 변수명 
			//	= new MultipartRequest(request, 저장시킬 폴더 경로, 제한 용량크기, 인코딩값, 파일명수정객체);
			// --> 위의 한 줄 실행시 전달된 첨부파일이 해당경로에 무조건 업로드
			
			// * 파일명이 같으면, 덮어쓰기가 가능하고
			// 	 한글/특수문자/띄어쓰기 포함시 서버에 따라 문제 발생 가능성 => 파일명 수정이 일반적
			//	 => 기본적으로 파일명이 중복되지 않게 변경하는 객체 : DefaultFileRenamePolicy 객체 (cos.jar에서 제공)
			//		동일한 파일명이 있으면 파일명 뒤에 카운트를 해서 숫자를 붙여 변경함
			
			// * 원하는 방식으로 파일명을 바꾸고자 할 경우 : FileRenamePolicy 인터페이스 구현하여 새로운 객체 만들어 사용
			//		- com.kh.common.MyFileRenamePolicy class 생성
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, 
															"UTF-8", new MyFileRenamePoilcy());
			
			// 3. DB에 기록할 데이터를 추출해서 vo에 저장
			//		- 카테고리 번호, 게시글 제목, 내용, 로그인한 회원번호 => BOARD 테이블로
			//		- 첨부파일이 있음 : 첨부파일명, 수정된 파일명, 저장경로 => ATTACHMENT 테이블 추가
			String category = multiRequest.getParameter("category");			// 카테고리 번호
			String title = multiRequest.getParameter("title");					// 게시글 제목
			String content = multiRequest.getParameter("content");				// 게시글 내용
			Member m = (Member)request.getSession().getAttribute("loginUser");
			int userNo = m.getUserNo();											// 로그인한 회원 번호
			
			Board b = new Board();
			b.setCategoryNo(category);
			b.setBoardTitle(title);
			b.setBoardContent(content);
			b.setBoardWriter(""+userNo);
			// ----------------- BOARD 테이블에 추가할 데이터정리

			Attachment at = null;			// 첨부파일이 있는 경우 객체를 생성

			// multiRequest.getOriginalFileName("키값") : 첨부파일이 있는 경우 "원본파일명" | 없으면 null
			if (multiRequest.getOriginalFileName("upfile") != null) {
				// 첨부파일이 있는 경우
				at = new Attachment();
				
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				at.setChangeName(multiRequest.getFilesystemName("upfile")); 	// 실제 저장된 경로를 알려주는 메소드
				at.setFilePath("resources/b_upfiles/");
			}
			// --------------- ATTACHMENT 테이블에 추가할 데이터 정리
			
			// 4. 서비스 요청(요청 처리)
			//	  게시글을 추가, 첨부파일이 있는 경우만 DB에 저장되도록
			//	  게시글 추가 성공, 첨부파일이 없는 경우 => 게시글 등록 성공
			//	  게시글 추가 성공, 첨부파일 정보 추가 성공 => 게시글 등록 성공
			//    게시글 or 첨부파일 정보 추가 실패 => 게시글 등록 실패
			int result = new BoardService().insertBoard(b, at);
			
			
			// 5. 결과에 따라 응답페이지 저장
			
			if (result > 0) {	// 게시글 등록 성공 => 게시글 목록페이지(첫번째)로 재요청
				request.getSession().setAttribute("alertMsg", "게시글이 등록되었습니다.");
				response.sendRedirect(request.getContextPath()+"/list.bo?cpage=1");
			} else { // 등록 실패 => 첨부 파일이 있을 경우 파일 삭제, 에러 페이지
				if (at != null) {
					new File(savePath + at.getChangeName()).delete();
				}
				request.setAttribute("errorMsg", "게시글 등록 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
			
			
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
