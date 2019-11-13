package com.blog.mapper;

import com.blog.bean.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {

    int insertBlog(@Param("blog") Blog blog);

    void deleteBlogById(@Param("id") int id);

    Blog getBlogById(@Param("id") int id);

    List<Blog> getBlogs();

    List<Blog> getAllBlogs();

    List<Blog> getAlgorithmBlogs();

    void insertToBlog(@Param("blog") Blog blog);

    Integer updateBlog(@Param("blog") Blog blog);
}
