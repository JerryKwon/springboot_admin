package com.fastcampus.admin.repository;

import com.fastcampus.admin.model.entity.AdminUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser,Long>{

}