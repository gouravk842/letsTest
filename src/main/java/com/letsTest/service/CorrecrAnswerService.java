package com.letsTest.service;

import com.letsTest.dto.CorrectAnswerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CorrecrAnswerService {
    List<CorrectAnswerDto> getAllCorrectAnswerByQuestionId(Long questionId,Long quizId);

    String saveAllCorrectAnswer(List<CorrectAnswerDto> correctAnswerDtos);
}
