package com.me.testgenerator.service;

import java.util.List;

import com.me.testgenerator.domain.Answer;

public interface IAnswerService {
    List<Answer> getAllAnswers();
    Answer getAnswerById(Long id);
    Answer createAnswer(Answer answer);
    Answer updateAnswer(Long id, Answer answer);
    boolean deleteAnswer(Long id);
}
