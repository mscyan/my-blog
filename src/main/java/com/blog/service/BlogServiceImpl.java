package com.blog.service;

import com.blog.bean.Blog;
import com.blog.mapper.BlogMapper;
import com.utils.Base64Util;
import com.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@Repository("blogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Integer insertOneBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @Override
    public List<Blog> getBlogs(int pageSize, int pageNumber, String themeId) {
        List<Blog> blogs = new ArrayList<>();
        if(themeId.equals("blogs")){
            blogs = blogMapper.getBlogs();
        }
        else if(themeId.equals("algorithm")){
            blogs = blogMapper.getAlgorithmBlogs();
        }
        return blogs;
    }

    @Override
    public Blog getBlogById(int id) {
        return blogMapper.getBlogById(id);
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
