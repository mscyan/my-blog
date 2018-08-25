package com.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: CYAN
 * @Date: 2018/8/22 22:27
 * @Description: 过滤器配置
 **/
@Configuration
public class FilterConfig
{
	@Bean
	public FilterRegistrationBean filterRegist()
	{
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new MyFilter());
		filterRegistrationBean.addUrlPatterns("/*");

		return filterRegistrationBean;
	}
}
