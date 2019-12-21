package com.fastcampus.admin.model.network;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.security.web.header.Header;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// @JsonInclude 를 통해서 json에 변수가 담길 때 상세한 설정해줄 수 있음
public class Header<T>{
    
    //api 응답시간
    // private LocalDateTime transactionTime;
    // @JsonProperty(value = "transaction_time")
    private LocalDateTime transactionTime; // 프론트와 통신할 때는 스트링으로 작성 why???
    
    //api 응답코드
    private String resultCode;

    //api 부가설명
    private String description;

    //data는 제너릭 형태로하여 전달함.
    private T data;


    //OK
    public static <T> Header<T> OK(){
        return (Header<T>) Header.builder().transactionTime(LocalDateTime.now()).resultCode("OK").description("OK").build();
    }



    //DATA OKAY
    public static <T> Header<T> OK(T data){
        return (Header<T>) Header.builder().transactionTime(LocalDateTime.now()).resultCode("OK").description("OK").data(data).build();
    }

    //ERROR
    
    public static <T> Header<T> Error(){
        return (Header<T>) Header.builder().transactionTime(LocalDateTime.now()).resultCode("ERROR").description(description).build();
    }
}