package com.utils;

import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.net.URLEncoder;

@Component
public class ValueTransform {

    public static String encode(String value){
        return Base64Util.encode(URLEncoder.encode(value));
    }

    public static String decode(String value){
        return URLDecoder.decode(Base64Util.decode(value));
    }
}
