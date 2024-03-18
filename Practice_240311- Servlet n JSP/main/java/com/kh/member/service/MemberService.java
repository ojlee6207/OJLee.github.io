package com.kh.member.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {
	// Member loginUser = new MemberService().loginMember(userId, userPwd);
	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		close(conn);
		
		return m;
	}
	
	// 회원 가입시 회원 정보 추가하는 메소드
	// 접근제한자 [예약어] 반환타입 메소드명([매개변수]) {}
	public int insertMember(Member m) {
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) DAO에게 데이터 전달과 함께 필요한 Method 호출
		int result = new MemberDao().insertMember(conn, m);
		
		// 3) DML 사용시 트랜잭션 처리
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		// 4) Connection 객체 반납(close)
		close(conn);
		
		return result;
	}
	
	// 회원 정보 변경시 변경하는 메소드
	public Member updateMember(Member m) {
		Connection conn = getConnection();
				
		// userId : 조건의 key값
		// 1) 유저 정보 변경 내용 반영 (DML-update)
		int result = new MemberDao().updateMember(conn, m);
		
		Member updateMember = null;
		// 2) 수정 성공 : 유저 정보 조회 후 반환(return)
		if (result > 0) {
			commit(conn);
			updateMember = new MemberDao().selectMember(conn, m.getUserId());
		} else {
			rollback(conn);
		}
		close(conn);
		return updateMember;
	}
	
	public Member selectMember(Member m) {
		Connection conn = getConnection();

		m = new MemberDao().selectMember(conn, m.getUserId());
		
		close(conn);
		return m;
	}
	
	public Member updatePassword(String userId, String userPwd, 
								  String updatePwd) {
		Connection conn = getConnection();
		
		// 비밀번호 변경(update, DML) => int(처리된 행 수)
		int result = new MemberDao().updatePassword(conn, userId, userPwd, updatePwd);
				
		Member updateMem = null;
		
		if(result > 0) {
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, userId);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return updateMem;
	}
	
	public int deleteMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId, userPwd);		
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
}
