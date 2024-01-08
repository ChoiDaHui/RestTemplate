package com.testapi.service;

import com.testapi.dto.MainDTO;
import com.testapi.mappers.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MainService {
    @Autowired
    MainMapper mainMapper;

    public void get_list(@RequestParam String Page, @RequestParam String perPage){
        mainMapper.get_list(Page, perPage);
    }
}
