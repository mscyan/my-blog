package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    public ModelAndView getBlogList(){
        ModelAndView mv = new ModelAndView();

        return mv;
    }
}
