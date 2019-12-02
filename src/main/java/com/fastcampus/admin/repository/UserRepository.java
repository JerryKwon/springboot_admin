package com.fastcampus.admin.repository;

import java.util.Optional;

import com.fastcampus.admin.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);

}