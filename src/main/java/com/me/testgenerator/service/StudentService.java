package com.me.testgenerator.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.testgenerator.domain.Student;
import com.me.testgenerator.domain.Test;
import com.me.testgenerator.repository.StudentRepository;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Test> getTestsByStudentId(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
    if (studentOptional.isPresent()) {
        Student student = studentOptional.get();
        return student.getTests(); 
    } else {
        return Collections.emptyList();
    }
    }
}
