package com.Faraday.Library.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class CloudinaryConfig {

    private Cloudinary cloudinary;

    @Autowired
    public CloudinaryConfig(@Value("${cloudinary.key}") String clkey,
                            @Value("{cloudinary.secret}") String clSecret,
                            @Value("${cloudinary.name}") String clName) {
        cloudinary = Singleton.getCloudinary();
        cloudinary.config.cloudName=clName;
        cloudinary.config.apiSecret=clSecret;
        cloudinary.config.apiKey=clkey;
    }

    public Map upload(Object file, Map params){
        try {
            return cloudinary.uploader().upload(file, params);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
