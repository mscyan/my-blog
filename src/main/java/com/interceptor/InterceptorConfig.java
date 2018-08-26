package com.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: CYAN
 * @Date: 2018/8/25 11:31
 * @Description:
 **/
//@Configuration
public class InterceptorConfig implements WebMvcConfigurer
{
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
//		registry.addInterceptor(new MyInterceptor()).excludePathPatterns("/blog/*");
	}
}
