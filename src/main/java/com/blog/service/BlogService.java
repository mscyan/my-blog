package com.blog.service;

import com.blog.bean.Blog;

import java.util.List;

/**
 * @Author: CYAN
 * @Date: 2018/8/21 22:26
 * @Description:
 **/
public interface BlogService
{
	List<Blog> getBlogList();

	int addBlog(Blog blog);

	Blog updateBlog(Blog blog);
}
