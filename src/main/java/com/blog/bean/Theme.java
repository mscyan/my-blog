package com.blog.bean;

/**
 * @Author: CYAN
 * @Date: 2018/8/21 17:12
 * @Description: 博客主题，java/c++/随笔/python等
 **/
public class Theme
{
	private int theme_id;
	private String theme_name;

	public int getTheme_id()
	{
		return theme_id;
	}

	public void setTheme_id(int theme_id)
	{
		this.theme_id = theme_id;
	}

	public String getTheme_name()
	{
		return theme_name;
	}

	public void setTheme_name(String theme_name)
	{
		this.theme_name = theme_name;
	}
}
