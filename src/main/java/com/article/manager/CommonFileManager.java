package com.article.manager;

import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.Json;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class CommonFileManager {

    @Value("${access_key}")
    private String accessKey;
    @Value("${secret_key}")
    private String secretKey;
    @Value("${bucket_name}")
    private String bucket_name;

    public String getToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket_name);
    }


    public String uploadFileToQiniu(MultipartFile file) throws IOException {
        String token = getToken();
        Configuration config = new Configuration(Zone.autoZone());
        UploadManager uploadManager = new UploadManager(config);
        Response response = uploadManager.put(file.getBytes(), null, token);
        System.out.println(response.bodyString());
        StringMap map = Json.decode(response.bodyString());
        String hash = (String) map.get("hash");
        return hash;
    }


    public String getFileFromQiniu(String reqId) {
        reqId = "9g4AAAAM4M07HuYV";
        return "";
    }

}
