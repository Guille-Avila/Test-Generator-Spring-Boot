package com.me.testgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola")
public class HelloController {

    @GetMapping("")
    public ResponseEntity<String> helloWorld() {
        String message = "Hola Mundo";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
