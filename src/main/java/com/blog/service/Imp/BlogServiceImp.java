package com.blog.service.Imp;

import com.blog.bean.Blog;
import com.blog.mapper.BlogMapper;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: CYAN
 * @Date: 2018/8/21 22:26
 * @Description:
 **/
@Service
public class BlogServiceImp implements BlogService
{
	@Autowired
	private BlogMapper blogMapper;

	@Override
	public List<Blog> getBlogList()
	{
		return blogMapper.getBlogList();
	}
}
