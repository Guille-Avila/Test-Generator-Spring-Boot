package com.me.testgenerator.repository;

import com.me.testgenerator.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
    // Puedes agregar metodos de consulta personalizados si es necesario
}
