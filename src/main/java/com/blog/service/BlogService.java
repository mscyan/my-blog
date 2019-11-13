package com.blog.service;

import com.blog.bean.Blog;
import com.utils.ResponseData;

import java.util.List;

public interface BlogService {

    Integer insertOneBlog(Blog blog);

    List<Blog> getBlogs(int pageSize, int pageNumber, String themeId);

    List<Blog> getAllBlogs();

    Blog getBlogById(int id);

    Integer updateBlog(Blog blog);

    ResponseData deleteBlogById_unreal(int id);

    ResponseData deleteBlogById_real(int id);
}
