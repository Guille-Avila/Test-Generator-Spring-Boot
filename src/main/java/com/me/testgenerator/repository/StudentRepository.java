package com.me.testgenerator.repository;

import com.me.testgenerator.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Puedes agregar metodos de consulta personalizados si es necesario
}
