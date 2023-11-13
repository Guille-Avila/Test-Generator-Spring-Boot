package com.me.testgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.me.testgenerator.domain.QuestionAnswers;

public interface QuestionAnswersRepository extends JpaRepository<QuestionAnswers, Long>{
    
}
