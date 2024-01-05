package com.testapi.controller;

import com.testapi.dto.MainDTO;
import com.testapi.service.OpenApiManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private OpenApiManager openApiManager;

    @GetMapping("/main")
    public String main(){
        return "/main";
    }

    @ResponseBody
    @GetMapping("/get_list")
    public List<String> get_list(){
        List<String> result = openApiManager.fetch();
        return result;
    }


}
