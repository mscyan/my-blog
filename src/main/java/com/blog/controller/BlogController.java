package com.blog.controller;

import com.blog.bean.Blog;
import com.blog.service.BlogService;
import com.utils.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Api(value = "Blog", description = "Blog包下内容")
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @ApiOperation(value = "获取Blog")
    @RequestMapping(value = "/getBlog", method = RequestMethod.GET)
    public ResponseData getBlogList(@RequestParam(value = "blogId", required = true) String blogId){
        return new ResponseData();
    }

    @ApiOperation(value = "提交blog")
    @RequestMapping(value = "commitBlog", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseData commitBlog(@RequestParam(value = "Blog") Blog blog){
        blogService.insertOneBlog(blog);
        return new ResponseData();
    }
}
