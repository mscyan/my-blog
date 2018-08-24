package com.blog.service.Imp;

import com.blog.bean.Theme;
import com.blog.mapper.ThemeMapper;
import com.blog.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: CYAN
 * @Date: 2018/8/21 22:27
 * @Description:
 **/
@Service
public class ThemeServiceImp implements ThemeService
{
	@Autowired
	private ThemeMapper themeMapper;

	@Override
	public List<Theme> getThemeList()
	{
		return themeMapper.getThemeList();
	}
}
