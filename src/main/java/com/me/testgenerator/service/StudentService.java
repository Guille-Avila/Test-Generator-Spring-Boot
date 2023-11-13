package com.me.testgenerator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.testgenerator.domain.AssignedTest;
import com.me.testgenerator.domain.Student;
import com.me.testgenerator.domain.Test;
import com.me.testgenerator.repository.AssignedTestRepository;
import com.me.testgenerator.repository.StudentRepository;
import com.me.testgenerator.repository.TestRepository;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AssignedTestRepository assignedTestRepository;
    @Autowired
    private TestRepository testRepository;


    // basic CRUD 
    public List<Student> getAllStudents() {

        List<Student> students = studentRepository.findAll();
        List<Student> studentswithoutTests = new ArrayList<>(students.size());

        for (Student student: students) {
            student.setTests(null);
            studentswithoutTests.add(student);
        }
        
        return studentswithoutTests;
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student newStudent) {

        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            student.setName(newStudent.getName());
            student.setEmail(newStudent.getEmail());

            return studentRepository.save(student);
        } else {
            return null;
        }
    }

    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // More Services

    public boolean assignTestToStudentById(Long id, List<Test> tests) {

        Optional<Student> studentOptional = studentRepository.findById(id);
        Optional<Test> optionalTest;

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            
            for (Test test: tests) {
                AssignedTest testToAdd = new AssignedTest();
                testToAdd.setStudent(student);
                optionalTest = testRepository.findById(test.getId());

                if (optionalTest.isPresent()){
                    Test testById = optionalTest.get();
                    testToAdd.setTest(testById);
                }
                assignedTestRepository.save(testToAdd);
            } 

        } else {
            return false;
        }

        return true;
    }

    public boolean submitTest(Long id, List<Test> tests) {
        return true;
    }

}
