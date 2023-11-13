package com.me.testgenerator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.testgenerator.DTO.QuestionDTO;
import com.me.testgenerator.domain.Answer;
import com.me.testgenerator.domain.Option;
import com.me.testgenerator.domain.Question;
import com.me.testgenerator.domain.QuestionAnswers;
import com.me.testgenerator.domain.QuestionOptions;
import com.me.testgenerator.repository.AnswerRepository;
import com.me.testgenerator.repository.OptionRepository;
import com.me.testgenerator.repository.QuestionRepository;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Question createQuestion(QuestionDTO request) {

        Question question = new Question();
        question.setText(request.getText());

        List<Option> options = optionRepository.findAllById(request.getOptions());
        List<Answer> answers = answerRepository.findAllById(request.getAnswers());

        if (!options.isEmpty()) {
            List<QuestionOptions> questionOptions = new ArrayList<>(options.size());
            options.forEach(option -> {
                QuestionOptions questionOption = new QuestionOptions();
                questionOption.setOption(option);
                questionOption.setQuestion(question);
                questionOptions.add(questionOption);
            });
            question.setOptions(questionOptions);
        }

        if (!answers.isEmpty()) {
            List<QuestionAnswers> questionAnswers = new ArrayList<>(answers.size());
            answers.forEach(answer -> {
                QuestionAnswers questionAnswer = new QuestionAnswers();
                questionAnswer.setAnswer(answer);
                questionAnswer.setQuestion(question);
                questionAnswers.add(questionAnswer);
            });
            question.setAnswers(questionAnswers);
        }

        return questionRepository.save(question);
    }

    public Question updateQuestion(Long id, Question newQuestion) {
        Optional<Question> questionOptional = questionRepository.findById(id);

        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();

            question.setText(newQuestion.getText());

            return questionRepository.save(question);
        } else {
            return null;
        }
    }

    public boolean deleteQuestion(Long id) {
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
