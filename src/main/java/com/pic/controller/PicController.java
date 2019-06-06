package com.pic.controller;

import com.pic.service.PicService;
import com.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/pic")
public class PicController {

    @Autowired
    private PicService picService;

    @RequestMapping(value = "/getpic/{picname}")
    public ResponseData getImage(@PathVariable("picname") String picName,
                         HttpServletRequest request, HttpServletResponse response){
        //根据picName获取图片二进制数据并返回；
        return picService.returnPic(request, response, picName);
    }

    @ResponseBody
    @RequestMapping(value = "/putpic", method = RequestMethod.PUT)
    public ResponseData uploadPic(MultipartFile file){
        return picService.uploadPic(file);
    }
}
