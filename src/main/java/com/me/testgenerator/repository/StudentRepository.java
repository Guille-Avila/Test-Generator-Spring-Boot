package com.me.testgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.testgenerator.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Puedes agregar metodos de consulta personalizados si es necesario
}
