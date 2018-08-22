package com.blog.mapper;

import com.blog.bean.Theme;
import org.apache.ibatis.annotations.Mapper;

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

	Theme getThemeById(int theme_id);

	boolean addTheme(Theme theme);

	boolean updateTheme(Theme theme);
}
