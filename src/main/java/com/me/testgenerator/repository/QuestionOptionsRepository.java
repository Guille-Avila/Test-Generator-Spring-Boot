package com.me.testgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.me.testgenerator.domain.QuestionOptions;

public interface QuestionOptionsRepository extends JpaRepository<QuestionOptions, Long>{
    
}
