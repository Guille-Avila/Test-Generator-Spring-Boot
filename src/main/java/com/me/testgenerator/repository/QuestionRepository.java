package com.me.testgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.testgenerator.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Puedes agregar metodos de consulta personalizados si es necesario
}
