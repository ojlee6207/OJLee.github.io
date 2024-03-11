package com.kh.member.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.close;

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

}
