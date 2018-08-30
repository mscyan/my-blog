package com.blog.mapper;

import com.blog.bean.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

	Blog getBlogById(@Param("blog_id") int blog_id);

	int addBlog(@Param("blog") Blog blog);

	Blog updateBlog(@Param("blog") Blog blog);
}
