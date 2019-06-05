package com.blog.mapper;

import com.blog.bean.Blog;

import java.util.List;

public interface BlogMapper {

    int insertBlog(Blog blog);

    void updateBlogById(Blog blog, int id);

    void deleteBlogById(int id);

    Blog selectBlogById(int id);

    List<Blog> selectBlogInRange(int pageSize, int pageNumber);
}
