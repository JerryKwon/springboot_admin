package com.fastcampus.admin.repository;

import java.util.Optional;

import com.fastcampus.admin.model.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{

     Optional<Category> findByTitle(String title);

     Optional<Category> findByType(String type);

}