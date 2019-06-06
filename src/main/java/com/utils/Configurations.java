package com.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application.yml")
public class Configurations {

    @Value("${pic_folder}")
    private String pic_folder;

    @Value("${pic_save_path}")
    private String pic_save_path;

    public String getPic_folder() {
        return pic_folder;
    }

    public String getPic_save_path() {
        return pic_save_path;
    }
}
