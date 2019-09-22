package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Star;

public interface StarRepository extends JpaRepository<Star, Integer> {

}
