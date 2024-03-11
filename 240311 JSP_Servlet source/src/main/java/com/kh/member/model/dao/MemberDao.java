package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.member.model.vo.Member;
import static com.kh.common.JDBCTemplate.close;

public class MemberDao {
	Properties prop = new Properties();
	
	// 생성자 부분에 xml 파일 연결
	public MemberDao() {
		String filepath = MemberDao.class.getResource("/db/sql/member-mapper.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	Member m = new MemberDao().loginMember(conn, userId, userPwd);

	public Member loginMember(Connection conn, String userId, String userPwd) {
		Member m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			// 미완선 sql을 완성하기! (? 위치에 해당하는 값을 매칭하기)
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			// 조회 결과가 있으면 한 행이 반환 or 없으면 아무것도 반환 X
			if (rset.next()) {
				m = new Member(
						rset.getInt("user_no"),
						rset.getString("user_id"),
						rset.getString("user_pwd"),
						rset.getString("user_name"),
						rset.getString("phone"),
						rset.getString("email"),
						rset.getString("address"),
						rset.getString("interest"),
						rset.getDate("enroll_date"),
						rset.getDate("modify_date"),
						rset.getString("status")
						);		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
}
