package com.kh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.vo.Person;

/**
 * Servlet implementation class OperationServlet
 */
@WebServlet("/operation.do")
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("big", 10000);
		request.setAttribute("small", 10);
		
		request.setAttribute("str1", "반갑습니다.");
		request.setAttribute("str2", "잘가요");
		
		request.setAttribute("p1", new Person("이오재", 32, "남"));
		request.setAttribute("p2", null);
		
		ArrayList<String> list1 = new ArrayList<>();
		request.setAttribute("list1", list1); // 비어있는 리스트 []
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("ㅋㅋㅋㅋㅋㅋ");
		request.setAttribute("list2", list2); // 데이터가 있는 리스트 ["ㅋㅋㅋㅋㅋㅋ"]
		
		request.getRequestDispatcher("views/1_EL/02_elOperation.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
