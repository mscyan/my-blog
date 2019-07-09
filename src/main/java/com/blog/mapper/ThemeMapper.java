package com.blog.mapper;

import com.blog.bean.Blog;
import com.blog.bean.Theme;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeMapper {

    int addTheme(Theme theme);

    int deleteThemeById(@Param("id") int id);

    int updateTheme(@Param("theme") Theme theme);

    List<Theme> getThemes();

    Theme getThemeById(@Param("id") int id);

    List<Theme> getThemesByBlogId(@Param("blogId") int blogId);

    List<Blog> getBlogsByThemeId(@Param("themeId") int themeId);

    int addThemeAndBlog(@Param("blog_id") int blog_id,
                        @Param("theme_id") int theme_id);

    int deleteThemeById4BlogId(@Param("blog_id") int blog_id,
                               @Param("theme_id") int theme_id);
}
