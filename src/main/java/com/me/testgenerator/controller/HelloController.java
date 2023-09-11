package com.me.testgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HelloController {

    @GetMapping("")
    public ResponseEntity<String> helloWorld() {
        String message = "Bienvenido al proyecto de generacion de Pruebas, puedes usar students, tests, questions, para empezar a crer tus preguntas y pruebas";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
