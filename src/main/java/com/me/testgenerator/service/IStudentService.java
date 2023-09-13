package com.me.testgenerator.service;

import java.util.List;

import com.me.testgenerator.domain.AssignedTest;
import com.me.testgenerator.domain.Student;

public interface IStudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student createStudent(Student student);
    Student updateStudent(Long id, Student student);
    boolean deleteStudent(Long id);
    List<AssignedTest> getTestsByStudentId(Long id);
}
