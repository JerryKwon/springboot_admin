package com.fastcampus.admin.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import com.fastcampus.admin.DemoApplicationTests;
import com.fastcampus.admin.model.entity.Category;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryRepositoryTest extends DemoApplicationTests{

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void create(){
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "Admin user";

        Category category = new Category();

        category.setTitle(title);
        category.setType(type);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);
        
        Category newCategory = categoryRepository.save(category);

        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getType(),type);
        Assert.assertEquals(newCategory.getTitle(), title);
    }

    @Test
    public void read(){

        Optional<Category> category = categoryRepository.findById(1L);

        category.ifPresent(selectedCategory ->{
            System.out.println(selectedCategory.toString());
        });


        // Optional<Category> category = categoryRepository.findByTitle("컴퓨터");

        // category.ifPresent(selectedCategory ->{
        //     System.out.println(selectedCategory.toString());
        // });
    }

}