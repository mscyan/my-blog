package com.pic.service;

import com.pic.bean.Picture;
import com.pic.mapper.PictureMapper;
import com.utils.Base64Util;
import com.utils.Configurations;
import com.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service("picService")
public class PicServiceImpl implements PicService {

    @Autowired
    private Configurations configurations;

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public ResponseData returnPic(HttpServletRequest request, HttpServletResponse response, String picName) {

//        System.out.println(picName);
        /**
         * todo 数据库中存储 uri - path的对应关系，必须先在数据库中查找到对应的path，才可以返回对应的图片，否则，返回图片不存在
         */
        String path = configurations.getPic_folder() + File.separator + picName;
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
            return new ResponseData(200, "success", "");
        }
        catch (Exception e){
            return new ResponseData(500, "error", e.getMessage());
        }
    }

    @Override
    public ResponseData uploadPic(MultipartFile file) {
        try {
            String savePath = configurations.getPic_save_path() + File.separator + file.getOriginalFilename();
            pictureMapper.insertPicture(new Picture(savePath, Base64Util.encode(savePath), 0));
            byte[] bytes = file.getBytes();
            Files.write(Paths.get(savePath), bytes);
        } catch (Exception ignored){
            ignored.printStackTrace();
            return new ResponseData(500, "error", ignored.getMessage());
        }
        return new ResponseData(200, "success", "");
    }
}
