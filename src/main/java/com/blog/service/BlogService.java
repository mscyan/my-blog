package com.blog.service;

import com.blog.bean.Blog;
import com.utils.ResponseData;

import java.util.List;

public interface BlogService {

    ResponseData insertOneBlog(Blog blog);

    ResponseData getBlogs(int pageSize, int pageNumber);

    ResponseData getBlogById(int id);

    ResponseData updateBlog(Blog blog);

    ResponseData deleteBlogById_unreal(int id);

    ResponseData deleteBlogById_real(int id);
}
