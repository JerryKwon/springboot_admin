package com.fastcampus.admin.repository;

import java.time.LocalDateTime;

import com.fastcampus.admin.DemoApplicationTests;
import com.fastcampus.admin.model.entity.AdminUser;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminUserRepositoryTest extends DemoApplicationTests{

    @Autowired
    AdminUserRepository adminUserRepository;

    @Test
    public void create(){

        AdminUser adminUser = new AdminUser();

        adminUser.setAccount("AdminUser03");
        adminUser.setPassword("AdminUser03");
        adminUser.setStatus("Registered");
        adminUser.setRole("PARTNER");
        // adminUser.setCreatedAt(LocalDateTime.now());
        // adminUser.setCreatedBy("Admin Server");

        AdminUser newAdminUser = adminUserRepository.save(adminUser);

        Assert.assertNotNull(newAdminUser);
        

    }

    @Test
    public void read(){

    }
}