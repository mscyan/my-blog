package com.blog.controller;

import com.blog.bean.Theme;
import com.blog.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: CYAN
 * @Date: 2018/8/22 0:10
 * @Description: blog板块核心功能controller
 **/
@Controller
@RequestMapping(value="/blog")
public class BlogHomeController
{
	@Autowired
	private ThemeService themeService;

	@ResponseBody
	@RequestMapping(value="/theme")
	public List<Theme> getThemeList()
	{
		List<Theme> themes = themeService.getThemeList();
		return themes;
	}
}
