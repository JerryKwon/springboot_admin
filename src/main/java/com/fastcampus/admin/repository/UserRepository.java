package com.fastcampus.admin.repository;

import com.fastcampus.admin.model.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);

    //Pageable 객체 주의!! (org.springframework.data.domain.Pageable)
    Page<User> findAll(Pageable pageable);

}