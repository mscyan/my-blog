package com.blog.service;

import com.blog.bean.Blog;
import com.blog.mapper.BlogMapper;
import com.utils.ResponseData;
import org.apache.ibatis.reflection.ReflectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("blogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

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

    @Override
    @Transactional
    public ResponseData testTransactionService(Blog blog) {

        blogMapper.insertToBlog(blog);

        blog.setId(2);
        blog.setContent("error 前");
        blogMapper.updateBlog(blog);
        int x = blog.getId();



        blog.setContent("error 后");
        blogMapper.updateBlog(blog);
        return new ResponseData();
    }
}
