package com.letsTest.service;

import com.letsTest.dto.AnswerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerService {

     String saveAnswer(AnswerDto answerDto);

     String deleteAnswerById(Long answerId);

     String EditOptions(AnswerDto answerDto);

     List<AnswerDto> getAllAnswerByQuestionId(Long questionId,Long quizId);

     String saveAllAnswer(List<AnswerDto> answerDto);
}
