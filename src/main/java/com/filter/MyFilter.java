package com.filter;

import org.springframework.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: CYAN
 * @Date: 2018/8/22 0:13
 * @Description: 过滤器
 **/
public class MyFilter implements Filter
{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		System.out.println("服务启动，MyFilter启动");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		filterChain.doFilter(request,servletResponse);
	}

	@Override
	public void destroy()
	{

	}
}
