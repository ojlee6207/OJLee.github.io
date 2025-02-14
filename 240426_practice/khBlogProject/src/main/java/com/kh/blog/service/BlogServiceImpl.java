package com.kh.blog.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.blog.model.dao.BlogDAO;
import com.kh.blog.model.vo.BlogPost;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	public BlogDAO bDao;
	
	@Autowired
	public SqlSessionTemplate sqlSession;
	
	@Override
	public int addBlogPost(BlogPost bp) {	
		return bDao.addBlogPost(sqlSession, bp); 
	}

}
