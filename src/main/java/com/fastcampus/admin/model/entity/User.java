package com.fastcampus.admin.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"orderGroupList"}) // 상호 참조로 무한루프 돌지 않도록 처리함.
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String account;

    private String password;

    private String status;

	private String email;
	
	private String phoneNumber;
    
    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

	//mappedBy의 변수는 Many에 해당하는 OrderGroup 클래스에 User클래스가 선언된 이름을 의미함.
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<OrderGroup> orderGroupList;

}