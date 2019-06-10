package com;

import com.utils.Base64Util;
import com.utils.Configurations;
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

        Integer x = null;
        try {
            x = Integer.parseInt("xcx");
        } catch (Exception e){

        }
        System.out.println(x);
//        System.out.println(Base64Util.decode("QzpcXFVzZXJzXFxBa2F6YW1cXERlc2t0b3BcUVHlm77niYcyMDE5MDUyMjE4MjgwOS5naWY="));
////
//        System.out.println("C:\\\\Users\\\\Akazam\\\\Desktop\\\\simages".length());
    }
}
