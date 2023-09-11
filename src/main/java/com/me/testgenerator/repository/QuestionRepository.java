package com.me.testgenerator.repository;

import com.me.testgenerator.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Puedes agregar metodos de consulta personalizados si es necesario
}
