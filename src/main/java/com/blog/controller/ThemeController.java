package com.blog.controller;

import com.blog.bean.Theme;
import com.blog.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @ResponseBody
    @RequestMapping(value="/themes")
    public List<Theme> getThemeList()
    {
        System.out.println("controller");
        List<Theme> themes = themeService.getThemeList();
        return themes;
    }

    @ResponseBody
    @RequestMapping(value="/get_theme")
    public Theme getThemeById(@RequestParam int theme_id)
    {
        Theme theme = new Theme();
        return theme;
    }

    @ResponseBody
    @RequestMapping(value="/add_theme")
    public String addTheme(@RequestParam String theme_name)
    {
        return "success";
    }
}
