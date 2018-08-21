package com.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: CYAN
 * @Date: 2018/8/21 16:15
 * @Description:
 **/
@Controller
@RequestMapping(value="/home")
public class HomeController
{
	@RequestMapping(value="/index")
	public ModelAndView home()
	{
		ModelAndView view = new ModelAndView("/pages/index");
		view.addObject("name","my-blog");
		return view;
	}
}
