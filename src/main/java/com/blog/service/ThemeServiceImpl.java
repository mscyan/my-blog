package com.blog.service;

import com.blog.bean.Theme;
import com.blog.mapper.ThemeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("themeService")
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeMapper themeMapper;

    @Override
    public int addTheme(Theme theme) {
        return themeMapper.addTheme(theme);
    }

    @Override
    public int deleteThemeById(int id) {
        return 0;
    }

    @Override
    public int updateTheme(Theme theme) {
        return 0;
    }

    @Override
    public List<Theme> getThemes() {
        List<Theme> themes = themeMapper.getThemes();
        return themes;
    }

    @Override
    public Theme getThemeById(int id) {
        Theme theme = themeMapper.getThemeById(id);
        return theme;
    }
}
