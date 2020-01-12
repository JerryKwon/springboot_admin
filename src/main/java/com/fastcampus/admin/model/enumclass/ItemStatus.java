package com.fastcampus.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemStatus {


    REGISTERED(0,"등록","등록상태 입니다"),
    UNREGISTERED(1,"해지","해지상태 입니다"),
    WAITING(2,"대기","대기상태 입니다");

    private Integer id;

    private String title;

    private String description;

}