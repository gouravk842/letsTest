package com.letsTest.service;

import com.letsTest.dto.QuestionDto;
import com.letsTest.dto.QuizDto;
import com.letsTest.entity.Quiz;
import com.letsTest.repository.QuizRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public QuizDto startExam(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        QuizDto quizDto = null;
        if (quiz.isPresent()) {
             quizDto = modelMapper.map(quiz, new TypeToken<QuizDto>() {
            }.getType());

        }
        return quizDto;
    }
}
