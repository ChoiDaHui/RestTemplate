package com.testapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MainDTO {
    private String name; //가맹점명
    private String address;//시군구명
    private int count; //조회수?
    private int page; //한 페이지 당 개수와 페이지 번호
    private int perPage;

}
