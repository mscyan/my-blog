package com.blog.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.blog.bean.Blog;
import com.blog.service.BlogService;
import com.utils.Base64Util;
import com.utils.DateUtil;
import com.utils.FileReader;
import com.utils.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;

@Controller
@Api(value = "/Blog", description = "Blog包下内容")
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @ApiOperation(value = "获取Blog")
    @ResponseBody
    @RequestMapping(value = "/getBlog", method = RequestMethod.GET)
    public ResponseData getBlogList(){

        ResponseData responseData = new ResponseData();
        responseData.setResponse_code(200);
        responseData.setResponse_data(JSONArray.toJSONString(blogService.getBlogs(0, 0)));
        responseData.setRemark("");
        return responseData;
    }

    @ResponseBody
    @RequestMapping(value = "/getBlogById/{id}", method = RequestMethod.GET)
    public ResponseData getBlogById(@PathVariable int id){

        ResponseData responseData = new ResponseData();
        responseData.setResponse_data(JSONArray.toJSONString(blogService.getBlogById(id)));
        return responseData;
    }

    @ApiOperation(value = "提交blog")
    @ResponseBody
    @RequestMapping(value = "/commitBlog", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseData commitBlog(@RequestParam("title") String title,
                                   @RequestParam("content_abstract") String content_abstract,
                                   MultipartFile file) throws IOException {

        String currentTime = DateUtil.getCurrentTime();
        Blog blog = new Blog();
        blog.setTitle(Base64Util.encode(URLEncoder.encode(title)));
        blog.setContent_abstract(Base64Util.encode(URLEncoder.encode(content_abstract)));
        blog.setCommit_date(currentTime);
        blog.setContent(Base64Util.encode(URLEncoder.encode(FileReader.getTextFromBlogFile(file))));
        blog.setTheme_id(0);
        blog.setLasted_update_date(currentTime);
        blog.setRead_count(0);
        blog.setReadable(1);

        Integer result = blogService.insertOneBlog(blog);
        return new ResponseData(200, result, "add blog success");
    }

    @RequestMapping("/back")
    public String blogManager(){
        return "/blogManager.html";
    }
}
