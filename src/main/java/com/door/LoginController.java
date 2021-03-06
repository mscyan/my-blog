package com.door;

import com.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/door")
public class LoginController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String door(){

        return "/login.html";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData login(@RequestBody TempInfo tempInfo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResponseData responseData = new ResponseData();

        if(tempInfo.getUsername().equals("yanchao") && tempInfo.getKey().equals("blog")){
            responseData.setResponse_code(200);
            responseData.setResponse_data("success");
            responseData.setRemark("");
            Cookie cookie = new Cookie("a2V5", "eW91a25vd3doYXQ=");
            cookie.setMaxAge(3600 * 24 * 7);
            cookie.setPath("/");
            response.addCookie(cookie);
            return responseData;
        }
        else{
            responseData.setResponse_code(200);
            responseData.setResponse_data("error");
            responseData.setRemark("");
            return responseData;
        }
    }
}
