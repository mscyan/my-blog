package com.blog.controller;

import com.alibaba.fastjson.JSONArray;
import com.blog.bean.Blog;
import com.blog.service.BlogService;
import com.blog.service.ThemeService;
import com.utils.DateUtil;
import com.utils.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(value = "/Blog", description = "Blog包下内容")
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private ThemeService themeService;

    @ApiOperation(value = "获取Blog")
    @ResponseBody
    @RequestMapping(value = {"/getBlog/{theme}", "/getBlog"}, method = RequestMethod.GET)
    public ResponseData getBlogList(@PathVariable(required = false) String theme){

        if(theme == null || theme.equals("")){
            theme = "blogs";
        }
        ResponseData responseData = new ResponseData();
        responseData.setResponse_code(200);
        responseData.setResponse_data(JSONArray.toJSONString(blogService.getBlogs(0, 0, theme)));
        responseData.setRemark("");
        return responseData;
    }

    @ResponseBody
    @RequestMapping(value = "/get_all_blog", method = RequestMethod.GET)
    public ResponseData getAllBlog(){
        ResponseData responseData = new ResponseData();
        responseData.setResponse_code(200);
        responseData.setResponse_data(JSONArray.toJSONString(blogService.getAllBlogs()));
        responseData.setRemark("");
        return responseData;
    }

    @ResponseBody
    @RequestMapping(value = "/get_blog_by_id", method = RequestMethod.GET)
    public ResponseData getBlogById(@RequestParam("id") Integer id){
        ResponseData responseData = new ResponseData();
        responseData.setResponse_code(200);
        Blog blog = blogService.getBlogById(id);
        responseData.setResponse_data(blog);
        responseData.setRemark("");
        return responseData;
    }

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    public String getBlogById(){
        return "/blogWithData.html";
    }

    @ResponseBody
    @RequestMapping(value = "/update_blog", method = RequestMethod.POST)
    public ResponseData updateBlog(@RequestParam("id") Integer id,
                                   @RequestParam("title") String title,
                                   @RequestParam("markdown") String markdown,
                                   @RequestParam("html") String html,
                                   @RequestParam("theme_id") Integer theme_id,
                                   @RequestParam("content_abstract") String content_abstract){
        String currentTime = DateUtil.getCurrentTime();
        Blog blog = new Blog();
        blog.setId(id);
        blog.setTitle(title);
        blog.setContent_abstract(content_abstract);
        blog.setMarkdown_content(markdown);
        blog.setHtml_content(html);
        blog.setTheme_id(theme_id);
        blog.setLasted_update_date(currentTime);
        blog.setReadable(1);

        Integer result = blogService.updateBlog(blog);
        return new ResponseData(200, result, "update blog success");
    }

    @ResponseBody
    @RequestMapping(value = "/getThemes", method = RequestMethod.GET)
    public ResponseData getThemes(){
        String themes = JSONArray.toJSONString(themeService.getThemes());
        return new ResponseData(200, themes, "success");
    }

    @RequestMapping(value = "blog_edit", method = RequestMethod.GET)
    public String blog_edit(){
        return "/edit/blog_edit.html";
    }

    @RequestMapping("/back")
    public String blogManager(){
        return "/blogManager.html";
    }

    @RequestMapping(value = "check_title", method = RequestMethod.POST)
    public String checkBlogTitle(){
        return "";
    }

    @RequestMapping(value = "/commit_blog", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData commitBlog(@RequestParam("title") String title,
                                   @RequestParam("markdown") String markdown,
                                   @RequestParam("html") String html,
                                   @RequestParam("theme_id") Integer theme_id,
                                   @RequestParam("content_abstract") String content_abstract){
        String currentTime = DateUtil.getCurrentTime();
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent_abstract(content_abstract);
        blog.setMarkdown_content(markdown);
        blog.setHtml_content(html);
        blog.setTheme_id(theme_id);
        blog.setCommit_date(currentTime);
        blog.setLasted_update_date(currentTime);
        blog.setRead_count(0);
        blog.setReadable(1);

        Integer result = blogService.insertOneBlog(blog);
        return new ResponseData(200, result, "add blog success");
    }
}
