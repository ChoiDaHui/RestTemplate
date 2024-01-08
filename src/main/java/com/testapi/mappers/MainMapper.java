package com.testapi.mappers;

import com.testapi.dto.MainDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface MainMapper {
    void get_list(@RequestParam String Page, @RequestParam String perPage);

    //mapper를 거치치않고 바로 db에 넣는 구문
    @Insert("insert into `data` values (#{name}, #{address},1)" +
            "on duplicate key update `count` = `count` + 1")
    void db_insert(MainDTO mainDTO);

}
