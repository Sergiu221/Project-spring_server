package com.sergiu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sergiu.entity.HelloEntity;

@Repository
public interface HelloRepository extends JpaRepository<HelloEntity, Integer> {

}
