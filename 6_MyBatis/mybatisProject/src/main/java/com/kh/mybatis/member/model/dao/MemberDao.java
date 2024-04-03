package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession sqlSession, Member m) {
		/*
		 * * 기존 방식
		 * int result = 0;
		 * PreparedStatement pstmt = null;
		 * String sql = prop.getProperty("insertMember");
		 * 
		 * try {
		 * 		pstmt = conn.prepareStatement(sql);
		 * 		pstmt.setString(1, m.getUserId());
		 * 		...
		 * 		result = pstmt.executeUpdate();
		 * } catch {
		 * } finally {
		 * 	 close(pstmt); 
		 * }
		 * return result;
		 * */
		/*
		 * sqlSession 객체에서 제공하는 메소드를 통해 sql문을 찾아서 실행하고, 결과를 바로 받음
		 * 
		 * 결과 = sqlSession.종류에_맞는_메소드("매퍼의_별칭.실행할_sql문_id", [sql문을 완성시킬 객체]);
		 */
		int result = sqlSession.insert("memberMapper.insertMember", m);
		return result;
	}

	// Member loginUser = mDao.loginMember(sqlSession, m);
	public Member loginMember(SqlSession sqlSession, Member m) {
		/*
		Member loginUser = sqlSession.selectOne("memberMapper.loginMember", m);
		
		return loginUser;
		*/
		// selectOne : 조회된 결과가 없을 경우, null 반환
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}

}
