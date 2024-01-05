package com.testapi;

import com.testapi.dto.MainDTO;
import com.testapi.service.OpenApiManager;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TestApiApplicationTests {
    private final String url = "https://api.odcloud.kr/api/15109950/v1/uddi:1f78fe49-78b4-4784-a5f0-e2c8a60515b4?page=1&perPage=1&serviceKey=OFbtvXMtuBc6t/3DYGVvVAtFtWdYiMZq8LCaFMLjOYvQ4Hk5knFcCyJmFKKkTk74J7K6O57MKYIIb8oL/Ogihw==";

    @Autowired
    OpenApiManager openApiManager;

    @Test
    void contextLoads() throws Exception {
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

        System.out.println(jsonObject.get("data"));
        System.out.println(name + "  " + address);
        System.out.println();


    }

}
