package com.me.testgenerator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.testgenerator.domain.Answer;
import com.me.testgenerator.repository.AnswerRepository;

@Service
public class AnswerService implements IAnswerService{

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.findById(id).orElse(null);
    }

    @Override
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer updateAnswer(Long id, Answer newAnswer) {
        Optional<Answer> answerOptional = answerRepository.findById(id);

        if (answerOptional.isPresent()) {
            Answer answer = answerOptional.get();

            answer.setText(newAnswer.getText());
            answer.setQuestion(newAnswer.getQuestion());
            
            return answerRepository.save(answer);
        }
        else {
            return null;
        }
    }

    @Override
    public boolean deleteAnswer(Long id) {
        if (answerRepository.existsById(id)) {
            answerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}

