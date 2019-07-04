package com.blog.mapper;

import com.blog.bean.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {

    int insertBlog(@Param("blog") Blog blog);

    void updateBlogById(@Param("blog") Blog blog,
                        @Param("id") int id);

    void deleteBlogById(@Param("id") int id);

    Blog getBlogById(@Param("id") int id);

    List<Blog> getBlogs();

    List<Blog> selectBlogInRange(@Param("pageSize") int pageSize,
                                 @Param("pageNumber") int pageNumber);

    void insertToBlog(@Param("blog") Blog blog);

    void updateBlog(@Param("blog") Blog blog);
}
