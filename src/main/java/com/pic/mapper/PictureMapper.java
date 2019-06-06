package com.pic.mapper;

import com.pic.bean.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureMapper {

    void insertPicture(@Param("picture") Picture picture);

    Picture getPictureByB64(@Param("given_uri") String given_uri);
}
