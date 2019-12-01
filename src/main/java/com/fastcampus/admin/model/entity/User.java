package com.fastcampus.admin.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User{

	private long id;
	
	private String account;

    private String password;

    private String status;

	private String email;
	
	private String phoneNumber;
    
    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

	private LocalDateTime createdAt;
	
	private String createdBy;
	
	private LocalDateTime updatedAt;
	
	private String updatedBy;

}