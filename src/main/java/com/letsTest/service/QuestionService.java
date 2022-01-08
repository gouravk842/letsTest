package com.letsTest.service;

import com.letsTest.dto.QuestionDto;
import com.letsTest.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface QuestionService {

    String saveQuestions(QuestionDto questionDto);

    String saveAllQuestions(List<QuestionDto> questionDto);

    String deleteQuestion(Long questionId);

    String EditQuestion(QuestionDto questionDto);



}
