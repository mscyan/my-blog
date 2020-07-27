package com.blog.service;

import com.blog.bean.Blog;
import com.blog.bean.BlogInfo;
import com.utils.ResponseData;

import java.util.List;

public interface BlogService {

    Integer insertOneBlog(Blog blog);

    List<BlogInfo> getBlogs(int pageSize, int pageNumber, String themeId);

    List<Blog> getAllBlogs();

    Blog getBlogById(int id);

    Integer updateBlog(Blog blog);

    ResponseData deleteBlogById_unreal(int id);

    ResponseData deleteBlogById_real(int id);

    ResponseData closeBlog(int id);

    ResponseData openBlog(int id);

    void saveOrUpdate(Blog blog);
}
