package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("home")
    @ResponseBody
    public String home(){

        return "hello world " + new Date();
    }

    @RequestMapping("/")
    public String index_default(){

        return "/index.html";
    }

    @RequestMapping("index")
    public String index(){

        return "/index.html";
    }
}
