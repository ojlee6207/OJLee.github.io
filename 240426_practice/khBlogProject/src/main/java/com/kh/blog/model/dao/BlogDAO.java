package com.kh.blog.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.blog.model.vo.BlogPost;

@Repository
public class BlogDAO {

	public int addBlogPost(SqlSessionTemplate sqlSession, BlogPost bp) {
		return sqlSession.insert("blogMapper.addBlogPost", bp);
	}

}
