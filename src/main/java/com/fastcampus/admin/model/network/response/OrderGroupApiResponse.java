package com.fastcampus.admin.model.network.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fastcampus.admin.model.enumclass.OrderType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderGroupApiResponse{

    private Long id;

    private Long userId;

    private String status;

    private OrderType orderType;

    private String revAddress;

    private String revName;

    private String paymentType;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private LocalDateTime createdAt;

    private String createdBy ;

    private LocalDateTime updatedAt;

    private String updatedBy;

    private List<ItemApiResponse> ItemApiResponseList;

}