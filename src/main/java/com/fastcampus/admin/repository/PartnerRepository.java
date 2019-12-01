package com.fastcampus.admin.repository;

import com.fastcampus.admin.model.entity.Partner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long>{

}