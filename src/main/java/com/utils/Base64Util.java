package com.utils;

import java.util.Base64;

public class Base64Util {

    public static String encode(String source){
        return new String(Base64.getEncoder().encode(source.getBytes()));
    }

    public static String decode(String source){
        return new String(Base64.getDecoder().decode(source.getBytes()));
    }
}
