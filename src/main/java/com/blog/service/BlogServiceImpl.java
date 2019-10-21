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
        for(Blog item : blogs){
            item.setTitle(URLDecoder.decode(Base64Util.decode(item.getTitle())));
            item.setHtml_content(URLDecoder.decode(Base64Util.decode(item.getHtml_content())));
            item.setContent_abstract(URLDecoder.decode(Base64Util.decode(item.getContent_abstract())));
        }
        return blogs;
    }

    @Override
    public Blog getBlogById(int id) {
        Blog blog = blogMapper.getBlogById(id);
        blog.setTitle(URLDecoder.decode(Base64Util.decode(blog.getTitle())));
        blog.setHtml_content(URLDecoder.decode(Base64Util.decode(blog.getHtml_content())));
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
