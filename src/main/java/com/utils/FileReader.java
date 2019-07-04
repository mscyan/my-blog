package com.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;

public class FileReader {

    public static String getTextFromBlogFile(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while((line = reader.readLine()) != null){
            sb.append(line);
        }

        return sb.toString();
    }
}
