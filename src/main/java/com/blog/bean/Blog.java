package com.blog.bean;

import java.util.Date;

/**
 * @Author: CYAN
 * @Date: 2018/8/21 16:55
 * @Description: 博客实体类
 **/
public class Blog
{
	private int blog_id;
	private String blog_title;
	private String blog_desc;
	private Date start_date;
	private Date last_modify_date;
	private int read_number;
	//	private String author;个人使用，不需要作者信息

	public String getBlog_desc()
	{
		return blog_desc;
	}

	public void setBlog_desc(String blog_desc)
	{
		this.blog_desc = blog_desc;
	}

	public int getRead_number()
	{
		return read_number;
	}

	public void setRead_number(int read_number)
	{
		this.read_number = read_number;
	}

	public int getBlog_id()
	{
		return blog_id;
	}

	public void setBlog_id(int blog_id)
	{
		this.blog_id = blog_id;
	}

	public String getBlog_title()
	{
		return blog_title;
	}

	public void setBlog_title(String blog_title)
	{
		this.blog_title = blog_title;
	}

	public Date getStart_date()
	{
		return start_date;
	}

	public void setStart_date(Date start_date)
	{
		this.start_date = start_date;
	}

	public Date getLast_modify_date()
	{
		return last_modify_date;
	}

	public void setLast_modify_date(Date last_modify_date)
	{
		this.last_modify_date = last_modify_date;
	}
}
