package com;

import com.utils.Base64Util;
import com.utils.Configurations;
import com.utils.ValueTransform;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Base64;
import java.util.Date;
import java.util.Properties;

@Controller
@Api(value = "Home", description = "Home", tags = "主页")
public class HomeController {

    @RequestMapping(value = "home", method = RequestMethod.GET)
    @ResponseBody
    public String home(){
        return "hello world " + new Date();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index_default(){
        return "/index.html";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(){

        return "/index.html";
    }

    public static void main(String[] args){

        String  value = "OS_0002_操作系统中进程的概念";
        System.out.println(ValueTransform.encode(value));
        System.out.println(ValueTransform.decode("JUU2JTkzJThEJUU0JUJEJTlDJUU3JUIzJUJCJUU3JUJCJTlGJUU0JUI4JUFEJUU4JUJGJTlCJUU3JUE4JThCJUU3JTlBJTg0JUU2JUE2JTgyJUU1JUJGJUI1"));
    }
}
