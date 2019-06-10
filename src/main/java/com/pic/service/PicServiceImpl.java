package com.pic.service;

import com.pic.bean.Picture;
import com.pic.mapper.PictureMapper;
import com.utils.Base64Util;
import com.utils.Configurations;
import com.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Service("picService")
public class PicServiceImpl implements PicService {

    @Autowired
    private Configurations configurations;

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public ResponseData returnPic(HttpServletRequest request, HttpServletResponse response, String picName) {
        Integer id = 40;
        try {
            id = Integer.parseInt(Base64Util.decode(picName));
        } catch (Exception e){
            //do nothing return the default pic NUMBER
        }
        Picture picture = pictureMapper.getPictureById(id);
        if(picture != null){
            String path = Base64Util.decode(picture.getGiven_uri());
            try {
                System.out.println(path);
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
                buffer.clear();
                channel.close();
                rafile.close();
                outputStream.flush();
                outputStream.close();
                return new ResponseData(200, picture, "");
            }
            catch (Exception e){
                return new ResponseData(500, "error", "");
            }
        }
        else{
            return new ResponseData(500, null, "");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void increaseFetchCount(int picId) {
        Picture picture = pictureMapper.getPictureById(picId);
        pictureMapper.increaseFetchCount(picId, picture.getFetch_count() + 1);
    }

    @Override
    public ResponseData uploadPic(MultipartFile file) {
        try {
            String savePath = configurations.getPic_save_path() + File.separator + file.getOriginalFilename();
            Picture picture = new Picture(savePath, Base64Util.encode(savePath), 0);
            pictureMapper.insertPicture(picture);
            byte[] bytes = file.getBytes();
            Files.write(Paths.get(savePath), bytes);
            return new ResponseData(200, Base64Util.encode(String.valueOf(picture.getId())), "");
        } catch (Exception ignored){
            ignored.printStackTrace();
            return new ResponseData(500, "error", ignored.getMessage());
        }
    }
}
