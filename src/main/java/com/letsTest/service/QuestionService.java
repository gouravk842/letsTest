package com.letsTest.service;

import com.letsTest.dto.QuestionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    String saveQuestions(QuestionDto questionDto);

    String deleteQuestion(Long questionId);

    String EditQuestion(QuestionDto questionDto);

    List<QuestionDto> getAllQuestionByQuizId(Long quizId);
}
