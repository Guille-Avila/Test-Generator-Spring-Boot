package com.me.testgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.testgenerator.domain.Option;

public interface OptionRepository extends JpaRepository<Option, Long> {
    // Puedes agregar metodos de consulta personalizados si es necesario
}
