package com.kh.board.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;
import com.kh.common.model.PageInfo;

public class BoardService {

	public int selectListCount() {
		int count = 0;
		
		Connection conn = getConnection();
		count = new BoardDao().selectListCount(conn); // select(DQL)
		
		close(conn);
		return count;
	}
	
	public ArrayList<Board> selectList(PageInfo pi) {
		ArrayList<Board> list = new ArrayList<>();
		
		Connection conn = getConnection();
		list = new BoardDao().selectList(conn);
		close(conn);
		return list;
	}

}
