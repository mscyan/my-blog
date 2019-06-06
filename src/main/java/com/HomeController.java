package com;

import com.utils.Base64Util;
import com.utils.Configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Base64;
import java.util.Date;
import java.util.Properties;

@Controller
public class HomeController {

    @Autowired
    private Configurations configurations;

    @RequestMapping("home")
    @ResponseBody
    public String home(){
        System.out.println(configurations.getPic_folder());
        return "hello world " + new Date();
    }

    @RequestMapping("/")
    public String index_default(){
        System.out.println(configurations.getPic_folder());
        return "/index.html";
    }

    @RequestMapping("index")
    public String index(){

        return "/index.html";
    }

    public static void main(String[] args){
//        System.out.println(Base64Util.encode("你好你好你"));
        System.out.println(Base64Util.decode("QzpcXFVzZXJzXFxBa2F6YW1cXERlc2t0b3BcUVHlm77niYcyMDE5MDUyMjE4MjgwOS5naWY="));
//
//        System.out.println("5L2g5aW95L2g5aW95L2g".length());
    }
}
