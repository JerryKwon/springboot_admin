package com.fastcampus.admin.model.network.request;

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
public class OrderDetailApiRequest{

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