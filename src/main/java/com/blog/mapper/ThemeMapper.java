package com.blog.mapper;

import com.blog.bean.Theme;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: CYAN
 * @Date: 2018/8/21 22:26
 * @Description:
 **/
@Mapper
public interface ThemeMapper
{
	List<Theme> getThemeList();

	Theme getThemeById(@Param("theme_id") int theme_id);

	boolean addTheme(@Param("theme") Theme theme);

	boolean updateTheme(@Param("theme") Theme theme);
}
