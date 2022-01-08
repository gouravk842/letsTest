package com.letsTest.service;

import com.letsTest.dto.QuizDto;
import com.letsTest.entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {
     Long SaveQuiz(QuizDto quizDto);

     String DeleteQuiz(Long quizeId);

     String EditQuiz(QuizDto quizDto);

     List<QuizDto> getQuizByCreatedById(Long createdBy);

     Quiz getQuiz(Long quizId);
}

