package com.fastcampus.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderType{

    ALL(0,"묶음","묶음 발송하는 상품입니다"),
    EACH(1,"개별","개별 발송하는 상품입니다");

    private Integer id;

    private String title;

    private String description;

}