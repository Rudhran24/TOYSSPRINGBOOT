package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Toys;

public interface ToysRepo extends JpaRepository<Toys,Integer>{
    
}