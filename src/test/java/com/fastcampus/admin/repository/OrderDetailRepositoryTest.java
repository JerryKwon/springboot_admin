package com.fastcampus.admin.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fastcampus.admin.DemoApplicationTests;
import com.fastcampus.admin.model.entity.OrderDetail;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDetailRepositoryTest extends DemoApplicationTests{

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setStatus("Waiting");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("Admin Server");
        
        // orderDetail.setOrderGroupId(1L);
        // orderDetail.setItemId(1L);

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

        Assert.assertNotNull(newOrderDetail);

    }

    @Test
    public void read(){

    }
}