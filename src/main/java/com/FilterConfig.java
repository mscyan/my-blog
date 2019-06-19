package com;

import com.extension.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.addUrlPatterns("/*");
        registrationBean.setFilter(new MyFilter());
        registrationBean.setName("MainFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
