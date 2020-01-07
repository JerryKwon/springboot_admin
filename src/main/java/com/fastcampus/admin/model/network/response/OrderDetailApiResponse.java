package com.fastcampus.admin.model.network.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailApiResponse{

    private Long id;

    private Long itemId;

    private Long orderGroupId;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;
    
    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

}