package com.me.testgenerator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.testgenerator.domain.Test;
import com.me.testgenerator.repository.TestRepository;

@Service
public class TestService implements ITestService{

    @Autowired
    private TestRepository testRepository;


    @Override
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    @Override
    public Test getTestById(Long id) {
        return testRepository.findById(id).orElse(null);
    }

    @Override
    public Test createTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Test updateTest(Long id, Test newTest) {
        Optional<Test> testOptional = testRepository.findById(id);

        if (testOptional.isPresent()) {
            
            Test test = testOptional.get();

            test.setName(newTest.getName());
            test.setDescription(newTest.getDescription());
            test.setQuestions(newTest.getQuestions());

            return testRepository.save(test);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteTest(Long id) {
        if (testRepository.existsById(id)) {
            testRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
}
