package com.fastcampus.admin.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fastcampus.admin.model.enumclass.UserStatus;

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

    @Enumerated(EnumType.STRING) // 클래스 값을 Enum으로 지정해 줄 수 있음
    private UserStatus status; // 고정된 값을 사용 => 변수를 enum화 시켜야 함. enum 클래스를 생성함.

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