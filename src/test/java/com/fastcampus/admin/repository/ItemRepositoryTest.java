package com.fastcampus.admin.repository;

import java.time.LocalDateTime;

import com.fastcampus.admin.DemoApplicationTests;
import com.fastcampus.admin.model.entity.Item;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemRepositoryTest extends DemoApplicationTests{

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){

        Item item = new Item();
        item.setStatus("Unregistered");
        item.setName("노트북");
        item.setTitle("삼성 노트북 9");
        item.setContent("2019년 형 노트북 입니다");
        item.setPrice(900000);
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
        // item.setPartnerId(1L);
        
        Item newItem = itemRepository.save(item);

        Assert.assertNotNull(newItem);
    }

    @Test
    public void read(){

    }

}