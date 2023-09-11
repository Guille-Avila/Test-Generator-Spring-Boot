package com.me.testgenerator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.testgenerator.domain.Question;
import com.me.testgenerator.repository.QuestionRepository;

@Service
public class QuestionService implements IQuestionService{
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Long id, Question question) {
        if (questionRepository.existsById(id)) {
            question.setId(id);
            return questionRepository.save(question);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteQuestion(Long id) {
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
