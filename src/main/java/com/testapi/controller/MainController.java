package com.testapi.controller;

import com.testapi.dto.MainDTO;
import com.testapi.service.MainService;
import com.testapi.service.OpenApiManager;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private OpenApiManager openApiManager;
    @Autowired
    private MainService mainService;
//    실행
    @GetMapping("/main")
    public String main(){
        return "/main";
    }

    //결과값 (임시), 버튼 누를때 리스트 호출
    @ResponseBody
    @GetMapping("/get_list")
    public String get_list(@RequestParam String page, @RequestParam String perPage){
        JSONArray result = openApiManager.fetch(page, perPage);
        //mainService.get_list(Page, perPage);
        return result.toString();
    }

    @PostMapping("/update_list")
    public void update_list(){

    }


}
