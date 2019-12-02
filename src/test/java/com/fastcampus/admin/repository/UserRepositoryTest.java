package com.fastcampus.admin.repository;

import java.time.LocalDateTime;

import com.fastcampus.admin.DemoApplicationTests;
import com.fastcampus.admin.model.entity.User;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        Assert.assertNotNull(newUser);

    }

    @Test
    public void read(){

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-2222-2222");

        Assert.assertNotNull(user);

    }

}