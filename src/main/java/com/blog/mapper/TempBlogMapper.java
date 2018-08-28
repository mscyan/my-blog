package com.blog.mapper;

import com.blog.bean.TempBlog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TempBlogMapper {
    TempBlog getTempBlog(int tempblog_id);

    List<TempBlog> getTempBlogList();

    TempBlog addTempBlog(TempBlog tempBlog);

    TempBlog updateTempBlog(TempBlog tempBlog);
}
