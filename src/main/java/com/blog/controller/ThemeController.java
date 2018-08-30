package com.blog.controller;

import com.blog.bean.Theme;
import com.blog.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @ResponseBody
    @RequestMapping(value="/theme")
    public List<Theme> getThemeList()
    {
        System.out.println("controller");
        List<Theme> themes = themeService.getThemeList();
        return themes;
    }
}
