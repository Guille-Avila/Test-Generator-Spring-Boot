package com.me.testgenerator.repository;

import com.me.testgenerator.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    // Puedes agregar metodos de consulta personalizados si es necesario
}
