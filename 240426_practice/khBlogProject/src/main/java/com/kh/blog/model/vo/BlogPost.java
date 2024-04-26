package com.kh.blog.model.vo;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlogPost {
	
	private String postId;
	private String title;
	private String content;
	private Date createdAt;
	private Date updateAt;
	
}
