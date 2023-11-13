package com.me.testgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.testgenerator.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    // Puedes agregar metodos de consulta personalizados si es necesario
}
