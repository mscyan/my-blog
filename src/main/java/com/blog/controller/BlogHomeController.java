package com.blog.controller;

import com.blog.bean.Theme;
import com.blog.service.ThemeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value="/index")
	public ModelAndView index()
	{
		ModelAndView model = new ModelAndView("/index.html");
		return model;
	}

	@ResponseBody
	@RequestMapping(value="/theme")
	public List<Theme> getThemeList()
	{
		System.out.println("controller");
		List<Theme> themes = themeService.getThemeList();
		return themes;
	}

	@RequestMapping(value="/addblog")
	public String addBlog(@RequestParam String blog_title,@RequestParam String blog_content)
	{
		System.out.println(blog_title+"\n"+blog_content);
		return "success";
	}
}
