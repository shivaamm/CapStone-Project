package com.org.tav.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiService {
    private ApiResponse apiResponse;
    private String apiKey = "&key=AIzaSyB7-gwN48voDBmzIicxsRat9eHTni1AMOM";
    private String geoCodingApi = "https://maps.googleapis.com/maps/api/geocode/json?address=";

    public Boolean validation(String addr) throws IOException {
        addr = addr.replace(' ', '+');
        URL url = new URL(geoCodingApi+addr+apiKey);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        String text = null;
        try (Scanner scanner = new Scanner(is, StandardCharsets.UTF_8.name())) {
            text = scanner.useDelimiter("\\A").next();
        }
        if(text==null)return false;
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(text);
        apiResponse = objectMapper.readValue(text, ApiResponse.class);
        System.out.println(apiResponse.getStatus());
        return apiResponse.checkResponse();
    }

}
