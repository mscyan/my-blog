package com.pic.controller;

import com.pic.service.PicService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/pic")
public class PicController {

    @Autowired
    private PicService picService;

    @RequestMapping(value = "/getpic")
    public void getImage(@RequestParam("picname") String picName,
                         HttpServletRequest request, HttpServletResponse response){
        //根据picName获取图片二进制数据并返回；
        picService.returnPic(request, response, picName);
    }
}
