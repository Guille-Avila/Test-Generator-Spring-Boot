package com.me.testgenerator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.testgenerator.domain.Answer;
import com.me.testgenerator.repository.AnswerRepository;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;
 
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    public Answer getAnswerById(Long id) {
        return answerRepository.findById(id).orElse(null);
    }

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }


    public Answer updateAnswer(Long id, Answer newAnswer) {
        Optional<Answer> answerOptional = answerRepository.findById(id);

        if (answerOptional.isPresent()) {
            Answer answer = answerOptional.get();

            answer.setText(newAnswer.getText());
            
            return answerRepository.save(answer);
        }
        else {
            return null;
        }
    }

    public boolean deleteAnswer(Long id) {
        if (answerRepository.existsById(id)) {
            answerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}

