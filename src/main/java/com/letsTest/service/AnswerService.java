package com.letsTest.service;

import com.letsTest.dto.AnswerDto;
import org.springframework.stereotype.Service;

@Service
public interface AnswerService {

     String saveAnswer(AnswerDto answerDto);

     String deleteAnswerById(Long answerId);

     String EditOptions(AnswerDto answerDto);
}
