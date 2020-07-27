package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
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
        //;
    }
}
