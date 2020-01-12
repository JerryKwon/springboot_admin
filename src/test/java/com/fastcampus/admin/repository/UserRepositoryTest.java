package com.fastcampus.admin.repository;

import java.time.LocalDateTime;

import com.fastcampus.admin.DemoApplicationTests;
import com.fastcampus.admin.model.entity.User;
import com.fastcampus.admin.model.enumclass.UserStatus;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UserRepositoryTest extends DemoApplicationTests{

    @Autowired
    UserRepository userRepository;

    @Test
    public void create(){

        String account = "Test01";
        String password = "Test01";
        String status = "registered";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-2222-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "Admin User";

        User user = new User();

        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(UserStatus.REGISTERED);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        // Builder
        // User u = new User.builder().account(account).password(password).status(status).email(email).build();

        User newUser = userRepository.save(user);

        Assert.assertNotNull(newUser);

    }

    @Test
    @Transactional
    public void read(){

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-2222-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            
            System.out.println(orderGroup.getRevName());
            System.out.println(orderGroup.getRevAddress());
            System.out.println(orderGroup.getTotalPrice());
            System.out.println(orderGroup.getTotalQuantity());
        
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("카테고리 명: "+ orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("파트너사 이름: "+orderDetail.getItem().getPartner().getName());
                System.out.println("주문 상품: " +orderDetail.getItem().getName());
                System.out.println("고객 센터 번호: " +orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태: "+orderDetail.getStatus());
                System.out.println("도착 예정일자 : "+orderDetail.getArrivalDate());

            });
        
        });

        Assert.assertNotNull(user);

    }

}