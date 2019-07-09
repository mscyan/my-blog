package com.blog.service;

import com.blog.bean.Blog;
import com.blog.mapper.BlogMapper;
import com.utils.Base64Util;
import com.utils.ResponseData;
import org.apache.ibatis.reflection.ReflectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLDecoder;
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
    public List<Blog> getBlogs(int pageSize, int pageNumber) {
        List<Blog> blogs = blogMapper.getBlogs();
        for(Blog item : blogs){
            item.setTitle(URLDecoder.decode(Base64Util.decode(item.getTitle())));
            item.setContent(URLDecoder.decode(Base64Util.decode(item.getContent())));
            item.setContent_abstract(URLDecoder.decode(Base64Util.decode(item.getContent_abstract())));
        }
        return blogs;
    }

    @Override
    public Blog getBlogById(int id) {
        Blog blog = blogMapper.getBlogById(id);
        blog.setTitle(URLDecoder.decode(Base64Util.decode(blog.getTitle())));
        blog.setContent(URLDecoder.decode(Base64Util.decode(blog.getContent())));
        blog.setContent_abstract(URLDecoder.decode(Base64Util.decode(blog.getContent_abstract())));
        return blog;
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
