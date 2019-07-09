package com.blog.service;

import com.blog.bean.Theme;
import com.blog.mapper.ThemeMapper;
import com.utils.ValueTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("themeService")
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeMapper themeMapper;

    @Override
    public int addTheme(Theme theme) {
        theme.setTheme_name(ValueTransform.encode(theme.getTheme_name()));
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
        for(Theme item : themes){
            item.setTheme_name(ValueTransform.decode(item.getTheme_name()));
        }
        return themes;
    }

    @Override
    public Theme getThemeById(int id) {
        Theme theme = themeMapper.getThemeById(id);
        theme.setTheme_name(ValueTransform.decode(theme.getTheme_name()));
        return theme;
    }
}
