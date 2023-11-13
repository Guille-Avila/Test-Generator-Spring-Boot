package com.me.testgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.testgenerator.domain.AssignedTest;

public interface AssignedTestRepository extends JpaRepository<AssignedTest, Long>{
    
}
