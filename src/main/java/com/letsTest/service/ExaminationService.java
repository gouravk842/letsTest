package com.letsTest.service;

import com.letsTest.dto.QuizDto;
import com.letsTest.dto.StudentAnswerDto;
import org.springframework.stereotype.Service;

@Service
public interface ExaminationService {
    QuizDto startExam(Long id);
    void saveAnswer(StudentAnswerDto studentAnswerDto);
}
