package com.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: CYAN
 * @Date: 2018/8/21 16:15
 * @Description:
 **/
@Controller
@RequestMapping(value="/todo")
public class TodoHomeController
{
	@RequestMapping(value="/index")
	public ModelAndView home()
	{
		ModelAndView view = new ModelAndView("/todo/todoindex");
		view.addObject("name","my-todo");
		return view;
	}
}
