package com.blog.controller;

import com.alibaba.fastjson.JSONArray;
import com.blog.bean.Blog;
import com.blog.service.BlogService;
import com.blog.service.ThemeService;
import com.utils.DateUtil;
import com.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private ThemeService themeService;


    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    public String getBlogById(){
        return "/blogWithData.html";
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

//    @ResponseBody
//    @RequestMapping(value = "/update_blog", method = RequestMethod.POST)
//    public ResponseData updateBlog(@RequestParam("id") Integer id,
//                                   @RequestParam("title") String title,
//                                   @RequestParam("markdown") String markdown,
//                                   @RequestParam("html") String html,
//                                   @RequestParam("theme_id") Integer theme_id,
//                                   @RequestParam("cover_image") String cover_image,
//                                   @RequestParam("content_abstract") String content_abstract){
//        String currentTime = DateUtil.getCurrentTime();
//        Blog blog = new Blog();
//        blog.setId(id);
//        blog.setTitle(title);
//        blog.setContent_abstract(content_abstract);
//        blog.setMarkdown_content(markdown);
//        blog.setCover_image(cover_image);
//        blog.setHtml_content(html);
//        blog.setTheme_id(theme_id);
//        blog.setLasted_update_date(currentTime);
//        blog.setReadable(1);
//
//        Integer result = blogService.updateBlog(blog);
//        return new ResponseData(200, result, "update blog success");
//    }

    @ResponseBody
    @RequestMapping(value = "/getThemes", method = RequestMethod.GET)
    public ResponseData getThemes(){
        String themes = JSONArray.toJSONString(themeService.getThemes());
        return new ResponseData(200, themes, "success");
    }

//    @RequestMapping(value = "/commit_blog", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseData commitBlog(@RequestParam("title") String title,
//                                   @RequestParam("markdown") String markdown,
//                                   @RequestParam("html") String html,
//                                   @RequestParam("theme_id") Integer theme_id,
//                                   @RequestParam("content_abstract") String content_abstract){
//        String currentTime = DateUtil.getCurrentTime();
//        Blog blog = new Blog();
//        blog.setTitle(title);
//        blog.setContent_abstract(content_abstract);
//        blog.setMarkdown_content(markdown);
//        blog.setHtml_content(html);
//        blog.setTheme_id(theme_id);
//        blog.setCommit_date(currentTime);
//        blog.setLasted_update_date(currentTime);
//        blog.setRead_count(0);
//        blog.setReadable(1);
//
//        Integer result = blogService.insertOneBlog(blog);
//        return new ResponseData(200, result, "add blog success");
//    }

    @ResponseBody
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public ResponseData saveOrUpdate(@RequestBody Blog blog, HttpServletRequest request) {
        blogService.saveOrUpdate(blog);
        return new ResponseData(200, blog.getId(), "保存成功");
    }

    @RequestMapping(value = "close_blog", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData closeBlog(@RequestParam("id") int id){
        return blogService.closeBlog(id);
    }

    @RequestMapping(value = "open_blog", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData openBlog(@RequestParam("id") int id){
        return blogService.openBlog(id);
    }
}
