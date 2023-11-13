package com.me.testgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.testgenerator.domain.Test;

public interface TestRepository extends JpaRepository<Test, Long> {
    // Puedes agregar metodos de consulta personalizados si es necesario
}
