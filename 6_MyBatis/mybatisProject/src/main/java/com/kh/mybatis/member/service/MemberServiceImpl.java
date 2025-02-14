package com.kh.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.template.Template;

public class MemberServiceImpl implements MemberService{
	
	private MemberDao mDao = new MemberDao();
	
	@Override
	public int insertMember(Member m) {
		/* 기존 JDBC 방식
		 * Connection conn = JDBCTemplate.getConnection();
		 * int result = new MemberDao().insertMember(conn, m);
		 * if (result >0) {
		 * 		JDBCTemplate.commit(conn);
		 * } else {
		 * 		JDBCTemplate.rollback(conn);
		 * }
		 * JDBCTemplate.close(conn);
		 * return result;
		 * */
		SqlSession sqlSession = Template.getSqlSession();
		int result = mDao.insertMember(sqlSession, m);
		
		if (result > 0) {
			sqlSession.commit();
		}
		// rollback : 여러개의 DML문을 실행시켰을때만 필수, 단일행의 경우 생략 가능
		// 			 => 일반 게시판 등록 시 : 게시글 정보 + 첨부파일 정보
		sqlSession.close();
		
		return result;
	}
	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		Member loginUser = mDao.loginMember(sqlSession, m);
		sqlSession.close();
		return loginUser;
	}
	@Override
	public int updateMember(Member m) {
		return 0;
	}
	@Override
	public int deleteMember(String userId) {
		return 0;
	}
}
