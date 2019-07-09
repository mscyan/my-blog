package com.blog.service;

import com.blog.bean.Theme;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ThemeService {

    int addTheme(Theme theme);

    int deleteThemeById(int id);

    int updateTheme(Theme theme);

    List<Theme> getThemes();

    Theme getThemeById(int id);
}
