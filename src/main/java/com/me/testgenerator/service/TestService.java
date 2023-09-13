package com.me.testgenerator.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.testgenerator.DTO.TestDTO;
import com.me.testgenerator.domain.Test;
import com.me.testgenerator.domain.Question;
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

            // If only update questions
            if (newTest.getName() == null && newTest.getDescription() == null) {
                test = updateQuestions(id, newTest);
            }
            else {
                test.setName(newTest.getName());
                test.setDescription(newTest.getDescription());
            }
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

    // Specific methods

    private Test updateQuestions(Long id, Test newTest) {
        Optional<Test> testOptional = testRepository.findById(id);

        if (testOptional.isPresent()) {
            
            Test test = testOptional.get();

            test.setQuestions(newTest.getQuestions());

            return testRepository.save(test);
        } 
        else {
            return null;
        }
    }

    public Set<Question> getQuestions (Long id) {
        Optional<Test> testOptional = testRepository.findById(id);
        if (testOptional.isPresent()) {
            return testOptional.get().getQuestions();
        }
        else {
            return null;
        }
    }
    
}
