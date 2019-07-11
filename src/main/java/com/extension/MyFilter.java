package com.extension;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(new Date().toString() + " - " + ((HttpServletRequest) request).getServletPath() + " " + request.getRemoteAddr());

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies == null){
            cookies = new Cookie[0];
        }
        if(((HttpServletRequest) request).getServletPath().equals("/favicon.ico")){
            ((HttpServletResponse) response).sendRedirect("/static/favicon.ico");
        }
        boolean hasPrivilege = false;
        for(Cookie cook : cookies){
            System.out.println(cook.getName() + " " + cook.getValue());
            if(cook.getName().equals("a2V5")){
                if(cook.getValue().equals("eW91a25vd3doYXQ=")){
                    hasPrivilege = true;
                    filterChain.doFilter(request, response);
                    return;
                }
            }
        }
        if(!hasPrivilege){
            if(((HttpServletRequest) request).getServletPath().startsWith("/door") ||
            ((HttpServletRequest) request).getServletPath().startsWith("/static") ||
            ((HttpServletRequest) request).getServletPath().startsWith("/pic/getpic") ||
            ((HttpServletRequest) request).getServletPath().equals("/") ||
            ((HttpServletRequest) request).getServletPath().startsWith("/blog/get")){
                filterChain.doFilter(request, response);
            }
            else{
                System.out.println( request.getRemoteAddr() + " " + request.getRemoteHost() + "没有权限登入");
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器destroy");
    }
}
