package com.blog.mapper;

import com.blog.bean.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: CYAN
 * @Date: 2018/8/21 22:26
 * @Description:
 **/
@Mapper
public interface BlogMapper
{
	List<Blog> getBlogList();

	Blog getBlogById(int blog_id);

	boolean addBlog(Blog blog);

	boolean updateBlog(Blog blog);
}
