package com.kh.notice.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

public class NoticeService {
	// 공지사항 목록 조회하여 반환하는 메소드
	// Connection 객체 생성 -> Dao 전달하여 DB 작업 => 반납
	// 공지사항 목록 반환
	public ArrayList<Notice> selectNoticeList() {
		// DQL(select) => transaction X => 자원 반납
		Connection conn = getConnection();	// Connection 객체 생성
		
		// NoticeDao에 Connection 객체와 함께 목록 조회 요청
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
		close(conn);
		
		// 조회된 목록을 리턴
		return list;
	}

	public Notice selectDetailNotice(int noticeNo) {
		Notice n = null;
		// Connection 객체 생성
		Connection conn = getConnection();
		// noticeNo에 해당하는 공지사항의 조회수 증가(업데이트) : DML => int
		int result = new NoticeDao().increaseCount(conn, noticeNo);
		// 조회수 증가 성공 시, 트랜잭션(commit) 후 상세 조회
		if (result > 0) {
			commit(conn);
			
			n = new NoticeDao().selectNotice(conn, noticeNo);
		// 조회수 증가 실패 시, 트랜잭션(rollback) 처리
		} else {
			rollback(conn);
		}
		// Connection 객체 반납
		close(conn);
		// 결과 리턴
		return n;
	}
	
	public int insertNotice(Notice notice) {
		int result = 0;
		
		Connection conn = getConnection();
		
		result = new NoticeDao().insertNotice(conn, notice);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateNotice(Notice notice) {
		int result = 0;
		
		Connection conn = getConnection();
		
		result = new NoticeDao().updateNotice(conn, notice);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteNotice(int noticeNo) {
		int result = 0;
		
		Connection conn = getConnection();
		
		result = new NoticeDao().deleteNotice(conn, noticeNo);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
}
