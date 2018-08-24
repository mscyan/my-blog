package com;

import com.blog.bean.Theme;
import com.blog.service.BlogService;
import com.blog.service.Imp.ThemeServiceImp;
import com.blog.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: CYAN
 * @Date: 2018/8/24 19:55
 * @Description:
 **/
public class BlogTest
{
	public static void main(String[] args)
	{
		ThemeService themeService = new ThemeServiceImp();
		List<Theme> themes = themeService.getThemeList();

		System.out.println(themes.size());
	}
}
