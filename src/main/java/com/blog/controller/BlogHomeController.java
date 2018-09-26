package com.blog.controller;

import com.blog.bean.Blog;
import com.blog.bean.BlogType;
import com.blog.bean.TempBlog;
import com.blog.bean.Theme;
import com.blog.service.BlogService;
import com.blog.service.ThemeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Date;
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
	private BlogService blogService;

	@RequestMapping(value="/index")
	public ModelAndView index()
	{
		ModelAndView model = new ModelAndView("/blog/blogindex");
		return model;
	}

	@ResponseBody
	@RequestMapping(value="/add_blog")
	public String addBlog(@RequestParam String blog_title,@RequestParam String blog_content) throws NoSuchFieldException {
		System.out.println(blog_title+"\n"+blog_content);
		Blog blog = new Blog();
		blog.setBlog_title(blog_title);
		blog.setBlog_content(blog_content);
		blog.setBlog_desc("描述");
		blog.setRead_number(0);
		blog.setStart_date(new Date());
		blog.setLast_modify_date(new Date());
		blog.setBlog_type(BlogType.TEXT);
		int result_blog = blogService.addBlog(blog);
		System.out.println("blog_id : "+result_blog);
		return "success";
	}

	@RequestMapping(value="/delete_blog")
	@ResponseBody
	public String deleteBlog(@RequestParam int blog_id)
	{
		return "success";
	}

	@ResponseBody
	@RequestMapping(value="/update_blog")
	public String updateBlog(@RequestParam Blog blog)
	{
		return "success";
	}

	@ResponseBody
	@RequestMapping(value="/get_blog")
	public List<Blog> getBlog()
	{
		List<Blog> blogs = blogService.getBlogList();
		return blogs;
	}

	/**
	 *
	 * @param tempBlog
	 * @return
	 * description 快速保存，在编写博客文章时会随时保存一个temp blog，避免丢失
	 */
	@ResponseBody
	@RequestMapping(value="/save_tempblog")
	public String addTempBlog(@RequestParam TempBlog tempBlog)
	{
		return "success";
	}

	@ResponseBody
	@RequestMapping(value="/update_tempblog")
	public String updateTempBlog(@RequestParam TempBlog tempBlog)
	{
		return "success";
	}
}
