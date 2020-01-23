package com.fastcampus.admin.model.network.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOrderInfoApiResponse {

    private UserApiResponse userApiResponse;

    // 주문 내역의 Response 또한 userApiResponse 아래에 위치하도록 코딩
    // private List<OrderGroupApiResponse> orderGroupApiResponseList;

    // OrderGroupApiResponse 아래에 위치할 수 있도록 삽입;
    // private List<ItemApiResponse> itemApiResponseList;

}