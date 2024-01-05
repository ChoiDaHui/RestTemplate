package com.testapi.service;

import com.testapi.dto.MainDTO;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OpenApiManager {
    private final String BASE_URL = "http://infuser.odcloud.kr/oas/docs?namespace=15109950/v1";
    private final String apiUri = "/uddi:1f78fe49-78b4-4784-a5f0-e2c8a60515b4";
    private final String page = "?page=1";
    private final String perPage = "&perPage=1";
    private final String serviceKey = "&serviceKey=OFbtvXMtuBc6t%2F3DYGVvVAtFtWdYiMZq8LCaFMLjOYvQ4Hk5knFcCyJmFKKkTk74J7K6O57MKYIIb8oL%2FOgihw%3D%3D";

    private final String url = "https://api.odcloud.kr/api/15109950/v1/uddi:1f78fe49-78b4-4784-a5f0-e2c8a60515b4?page=1&perPage=1&serviceKey=OFbtvXMtuBc6t/3DYGVvVAtFtWdYiMZq8LCaFMLjOYvQ4Hk5knFcCyJmFKKkTk74J7K6O57MKYIIb8oL/Ogihw==";

    private String makeUrl() throws UnsupportedEncodingException{
        return BASE_URL+
                apiUri+
                page+
                perPage+
                serviceKey;
    }

    public List<String> fetch(){
//        public ResponseEntity<?> fetch(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(result);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        String name = null;
        String address = null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            name = item.getString("가맹점명");
            address = item.getString("시군구명");
        }
        List<String> resultList = new ArrayList<>();
        resultList.add(name);
        resultList.add(address);

        return resultList;
    }




}
