package com.pic.service;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PicService {

    void returnPic(HttpServletRequest request, HttpServletResponse response, String picName);
}
