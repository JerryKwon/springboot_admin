package com.fastcampus.admin.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fastcampus.admin.DemoApplicationTests;
import com.fastcampus.admin.model.entity.OrderGroup;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderGroupRepositoryTest extends DemoApplicationTests{

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    public void create(){

        OrderGroup orderGroup = new OrderGroup();

        orderGroup.setStatus("COMPLETE");
        orderGroup.setOrderType("ALL");
        orderGroup.setRevAddress("서울시 강남구");
        orderGroup.setRevName("홍길동");
        orderGroup.setPaymentType("CARD");
        orderGroup.setTotalPrice(BigDecimal.valueOf(900000));
        orderGroup.setTotalQuantity(1);
        orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
        orderGroup.setArrivalDate(LocalDateTime.now());
        orderGroup.setCreatedAt(LocalDateTime.now());
        orderGroup.setCreatedBy("Admin Server");
        // orderGroup.setUserId(1L);

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);

        Assert.assertNotNull(newOrderGroup);

    }

    public void read(){

    }

}