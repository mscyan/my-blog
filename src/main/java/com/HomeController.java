package com;

import com.utils.Base64Util;
import com.utils.Configurations;
import com.utils.ValueTransform;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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
        //;
    }
}
