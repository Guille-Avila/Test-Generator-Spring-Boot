package com.me.testgenerator.repository;

import com.me.testgenerator.domain.AssignedTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignedTestRepository extends JpaRepository<AssignedTest, Long>{
    
}
