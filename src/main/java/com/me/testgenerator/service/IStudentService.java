package com.me.testgenerator.service;

import java.util.List;

import com.me.testgenerator.domain.Student;
import com.me.testgenerator.domain.Test;

public interface IStudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student createStudent(Student student);
    Student updateStudent(Long id, Student student);
    boolean deleteStudent(Long id);
    List<Test> getTestsByStudentId(Long id);
}
