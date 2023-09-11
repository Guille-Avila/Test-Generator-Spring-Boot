package com.me.testgenerator.service;

import java.util.List;

import com.me.testgenerator.domain.Question;

public interface IQuestionService {
    List<Question> getAllQuestions();
    Question getQuestionById(Long id);
    Question createQuestion(Question question);
    Question updateQuestion(Long id, Question question);
    boolean deleteQuestion(Long id);
}
