package com.me.testgenerator.service;

import java.util.List;

import com.me.testgenerator.domain.Test;

public interface ITestService {
    List<Test> getAllTests();
    Test getTestById(Long id);
    Test createTest(Test test);
    boolean deleteTest(Long id);
}
