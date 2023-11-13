package com.me.testgenerator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.testgenerator.DTO.TestDTO;
import com.me.testgenerator.domain.Question;
import com.me.testgenerator.domain.Test;
import com.me.testgenerator.domain.TestQuestions;
import com.me.testgenerator.repository.QuestionRepository;
import com.me.testgenerator.repository.TestRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TestService {

    @Autowired
    private TestRepository testRepository;
    @Autowired
    private QuestionRepository questionRepository;


    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    public Test getTestById(Long id) {
        return testRepository.findById(id).orElse(null);
    }

    public Boolean createTest(TestDTO test) {

        String name = test.getName();
        String description = test.getDescription();
        Test newTest = new Test();

        newTest.setName(name);
        newTest.setDescription(description);

        List<Question> questions = test.getQuestions();
        
        if (!questions.isEmpty()) {
            List<TestQuestions> testQuestions = setQuestions(newTest, questions);
            newTest.setTestQuestions(testQuestions);
        } 

        testRepository.save(newTest);

        return true;
    }

    private List<TestQuestions> setQuestions(Test test, List<Question> questions) {
        Optional<Question> optionalQuestion;
        List<TestQuestions> testQuestions = new ArrayList<>(questions.size());

        for (Question idQuestion: questions) {
            TestQuestions newTestQuestion = new TestQuestions();
            optionalQuestion = questionRepository.findById(idQuestion.getId());

            if (optionalQuestion.isPresent()) {
                Question question = optionalQuestion.get();
                newTestQuestion.setQuestion(question);
                newTestQuestion.setTest(test);
            } 

            testQuestions.add(newTestQuestion);
        }

        return testQuestions;
    }

    @Transactional
    public Boolean updateTest(Long id, TestDTO newTest) {
        Optional<Test> testOptional = testRepository.findById(id);

        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            test.setName(newTest.getName());
            test.setDescription(newTest.getDescription());

            // Lista ids questions request
            List<Long> newQuestionIds = newTest.getQuestions().stream()
                    .map(Question::getId)
                    .collect(Collectors.toList());

            // Remove questions que no esten en request
            test.getTestQuestions().removeIf(testQuestion ->
                    !newQuestionIds.contains(testQuestion.getQuestion().getId()));

            // Agrega questions nuevas del request a test
            newTest.getQuestions().forEach(question -> {
                if (!test.getTestQuestions().stream()
                        .anyMatch(testQuestion -> testQuestion.getQuestion().getId().equals(question.getId()))) {
                    questionRepository.findById(question.getId()).ifPresent(newQuestion -> {
                        TestQuestions newTestQuestion = new TestQuestions();
                        newTestQuestion.setQuestion(newQuestion);
                        newTestQuestion.setTest(test);
                        test.getTestQuestions().add(newTestQuestion);
                    });
                }
            });

            testRepository.save(test);
            return true;
        } else {
            return false;
        }
    }


    public boolean deleteTest(Long id) {
        if (testRepository.existsById(id)) {
            testRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
