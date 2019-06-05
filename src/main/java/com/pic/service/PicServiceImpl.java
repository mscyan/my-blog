package com.pic.service;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Service("picService")
public class PicServiceImpl implements PicService {

    @Override
    public void returnPic(HttpServletRequest request, HttpServletResponse response, String picName) {

        System.out.println(picName);
        String path = "C:\\Users\\yanchao\\Desktop\\simages\\" + picName;
        try {
            OutputStream outputStream = response.getOutputStream();
            RandomAccessFile rafile = new RandomAccessFile(path, "r");
            FileChannel channel = rafile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int readMark = channel.read(buffer);
            while(readMark != -1){
                byte[] bytes = buffer.array();
                outputStream.write(bytes);
                buffer.clear();
                readMark = channel.read(buffer);
            }
            channel.close();
            rafile.close();
            outputStream.close();
        }
        catch (Exception e){
//            e.printStackTrace();
//            try {
//                response.getWriter().write("error occured in server");
//            } catch (IOException e1) {
////                e1.printStackTrace();
//                return;
//            }
            return;
        }
    }
}
