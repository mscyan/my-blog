package com;

import com.alibaba.druid.support.json.JSONUtils;
import com.article.manager.CommonFileManager;
import com.baidu.ueditor.ActionEnter;
import com.qiniu.common.QiniuException;
import com.qiniu.util.Auth;
import io.swagger.annotations.Api;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@Api(value = "Home", description = "Home", tags = "主页")
public class HomeController {

    @Autowired
    private CommonFileManager commonFileManager;

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

    @RequestMapping(value = "/ueditor/getConfig")
    public String getConfig(HttpServletRequest request,
                            HttpServletResponse response) {

        return "redirect:/static/ueditor/jsp/config.json";
    }

    @RequestMapping(value = "/ueditor/uploadFile")
    @ResponseBody
    public String dispatcher(HttpServletRequest request,
                             MultipartFile upfile,
                             HttpServletResponse response) throws IOException {
            String hash = commonFileManager.uploadFileToQiniu(upfile);

            Map<String, Object> map = new HashMap<>();
            map.put("state", "SUCCESS") ;
            map.put("original", "abc.jpg") ;
            map.put("size", 12312) ;
            map.put("title", "abc.jpg") ;
            map.put("type", "jpg") ;
            map.put("url", "http://img.zelcyan.cn/" + hash) ;
            return JSONUtils.toJSONString(map);
    }


    public static void main(String[] args){
        //;
        String accessKey = "qZ9FKuHUuhiT8-tvaW8mkMWiCd-a7scNkzrQujhN";
        String secretKey = "Zn9uo8dSvnnBFKPsLPJXsyiOjq90TrjwTR4-I165";
        String bucket_name = "zelcyan-img";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket_name);
        System.out.println(upToken);
    }
}
