package com.extension;

import com.utils.DateUtil;

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
//        System.out.println(request.getAttribute("X-real-ip") + "  " + DateUtil.getCurrentTime() + " : 登入系统" + " ][ " + ((HttpServletRequest) request).getServletPath());
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

            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器destroy");
    }
}
