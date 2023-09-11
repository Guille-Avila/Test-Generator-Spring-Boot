package com.me.testgenerator.repository;

import com.me.testgenerator.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
    // Puedes agregar metodos de consulta personalizados si es necesario
}
