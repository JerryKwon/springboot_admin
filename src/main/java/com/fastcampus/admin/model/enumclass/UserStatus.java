package com.fastcampus.admin.model.enumclass;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus {

    // index, title, desc 순서
    REGISTERED(0,"등록상태","사용자 등록 상태"),
    UNREGISTERED(1,"해지","사용자 해지 상태");

    private Integer id;

    private String title;

    private String description;

}