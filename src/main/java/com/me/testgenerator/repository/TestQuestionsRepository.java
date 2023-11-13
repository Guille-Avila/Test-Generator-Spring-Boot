package com.me.testgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.testgenerator.domain.TestQuestions;

public interface TestQuestionsRepository extends JpaRepository<TestQuestions, Long>{
    
}
