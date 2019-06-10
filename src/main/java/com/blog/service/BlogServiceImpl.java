package com.blog.service;

import com.blog.bean.Blog;
import com.utils.ResponseData;
import org.springframework.stereotype.Repository;

@Repository("blogService")
public class BlogServiceImpl implements BlogService {
    @Override
    public ResponseData insertOneBlog(Blog blog) {
        return null;
    }

    @Override
    public ResponseData getBlogs(int pageSize, int pageNumber) {
        return null;
    }

    @Override
    public ResponseData getBlogById(int id) {
        return null;
    }

    @Override
    public ResponseData updateBlog(Blog blog) {
        return null;
    }

    @Override
    public ResponseData deleteBlogById_unreal(int id) {
        return null;
    }

    @Override
    public ResponseData deleteBlogById_real(int id) {
        return null;
    }
}
