package com.pic.controller;

import com.pic.bean.Picture;
import com.pic.service.PicService;
import com.utils.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/pic")
@Api(value = "Picture", description = "Pic Controller", tags = "图片包下的内容")
public class PicController {

    @Autowired
    private PicService picService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String picIndex(){
        return "/pic/pic_register.html";
    }

    @ApiOperation("根据given_uri获取图片")
    @RequestMapping(value = "/getpic/{picname}", method = RequestMethod.GET)
    public void getImage(@PathVariable("picname") String picName,
                         HttpServletRequest request, HttpServletResponse response){
        Object j = picService.returnPic(request, response, picName).getResponse_data();
        if(j.getClass().equals(Picture.class)){
            Picture p = (Picture) j;
            picService.increaseFetchCount(p.getId());
        }
    }

    @ApiOperation(value = "上传图片")
    @ResponseBody
    @RequestMapping(value = "/putpic", method = {RequestMethod.PUT, RequestMethod.POST})
    public ResponseData uploadPic(MultipartFile file){
        return picService.uploadPic(file);
    }
}
