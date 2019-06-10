package com.pic.service;

import com.pic.bean.Picture;
import com.utils.ResponseData;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PicService {

    ResponseData returnPic(HttpServletRequest request, HttpServletResponse response, String picName);

    void increaseFetchCount(int picId);

    ResponseData uploadPic(MultipartFile file);
}
