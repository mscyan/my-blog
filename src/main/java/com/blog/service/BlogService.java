package com.blog.service;

import com.blog.bean.Blog;
import com.utils.ResponseData;

import java.util.List;

public interface BlogService {

    Integer insertOneBlog(Blog blog);

    List<Blog> getBlogs(int pageSize, int pageNumber);

    Blog getBlogById(int id);

    ResponseData updateBlog(Blog blog);

    ResponseData deleteBlogById_unreal(int id);

    ResponseData deleteBlogById_real(int id);
}
