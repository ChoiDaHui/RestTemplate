package com.testapi.service;

import com.testapi.dto.MainDTO;
import com.testapi.mappers.MainMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class OpenApiManager {
//    private final String BASE_URL = "http://infuser.odcloud.kr/oas/docs?namespace=15109950/v1";
//    private final String apiUri = "/uddi:1f78fe49-78b4-4784-a5f0-e2c8a60515b4";
//    private final String page = "?page=1";
//    private final String perPage = "&perPage=1";
//    private final String serviceKey = "&serviceKey=OFbtvXMtuBc6t%2F3DYGVvVAtFtWdYiMZq8LCaFMLjOYvQ4Hk5knFcCyJmFKKkTk74J7K6O57MKYIIb8oL%2FOgihw%3D%3D";

    @Autowired
    MainMapper mainMapper;
    private final String url = "https://api.odcloud.kr/api/15109950/v1/uddi:1f78fe49-78b4-4784-a5f0-e2c8a60515b4?page=1&perPage=1&serviceKey=OFbtvXMtuBc6t/3DYGVvVAtFtWdYiMZq8LCaFMLjOYvQ4Hk5knFcCyJmFKKkTk74J7K6O57MKYIIb8oL/Ogihw==";
    private final String SERVICE_KEY = "OFbtvXMtuBc6t/3DYGVvVAtFtWdYiMZq8LCaFMLjOYvQ4Hk5knFcCyJmFKKkTk74J7K6O57MKYIIb8oL/Ogihw==";

    //가맹점, 시군구명 정보 뽑아냄
    public JSONArray fetch(String Page, String perPage){
//        public ResponseEntity<?> fetch(){

        URI uri = UriComponentsBuilder
                .fromUriString("https://api.odcloud.kr/api/15109950/v1/uddi:1f78fe49-78b4-4784-a5f0-e2c8a60515b4")
                .queryParam("page", Page)
                .queryParam("perPage", perPage)
                .queryParam("serviceKey", SERVICE_KEY)
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        JSONObject jsonObject = new JSONObject(result);
        JSONArray jsonArray = (JSONArray)jsonObject.get("data");

        for (int i = 0; i < jsonArray.length(); i++) {
            MainDTO mainDTO = new MainDTO();
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
            mainDTO.setName(jsonObject1.get("가맹점명").toString());
            mainDTO.setAddress(jsonObject1.get("시군구명").toString());
            mainMapper.db_insert(mainDTO);
            System.out.println(jsonObject1);
        }

        return jsonArray;


//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
//        if (responseEntity.getStatusCode().is2xxSuccessful()) {
//            return Collections.singletonList(responseEntity.getBody());
//        } else {
//            System.out.println("Error: " + responseEntity.getStatusCodeValue());
//            return null;
//        }
    }






}
