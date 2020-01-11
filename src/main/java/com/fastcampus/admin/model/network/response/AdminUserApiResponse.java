package com.fastcampus.admin.model.network.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminUserApiResponse{

    private Long id;

    private String account;

    private String password;

    private String status;

    private String role;

    private LocalDateTime lastLoginAt;

    private LocalDateTime passwordUpdatedAt;

    private int loginFailCount;

    private LocalDateTime registeredAt;
    
    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    
}