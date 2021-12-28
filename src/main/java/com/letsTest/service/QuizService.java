package com.letsTest.service;

import com.letsTest.dto.QuizDto;
import org.springframework.stereotype.Service;

@Service
public interface QuizService {
     String SaveQuiz(QuizDto quizDto);

     String DeleteQuiz(Long quizeId);

     String EditQuiz(QuizDto quizDto);
}

