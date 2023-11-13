package com.me.testgenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.testgenerator.DTO.TestDTO;
import com.me.testgenerator.domain.Test;
import com.me.testgenerator.service.TestService;

@RestController
@RequestMapping("/tests")
public class TestController {

    @Autowired
    private TestService testService;

    // Basic CRUD

    @GetMapping("")
    public ResponseEntity<List<Test>> getAllTests() {
        try {
        List<Test> tests = testService.getAllTests();
        return new ResponseEntity<>(tests, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Test> getTestById(@PathVariable Long id) {
        Test test = testService.getTestById(id);
        if (test != null) {
            return new ResponseEntity<>(test, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> createTest(@RequestBody TestDTO test) {
        Boolean createdTest = testService.createTest(test);
        if (createdTest) {
            return new ResponseEntity<>("Test Created Successfully", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Create Test Fail", HttpStatus.BAD_REQUEST);
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTest(@PathVariable Long id, @RequestBody TestDTO test) {
        Boolean updatedTest = testService.updateTest(id, test);
        if (updatedTest != null) {
            return new ResponseEntity<>("Test Updated Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
        boolean deleted = testService.deleteTest(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
