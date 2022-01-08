package com.letsTest.service;

import com.letsTest.dto.QuizDto;
import org.springframework.stereotype.Service;

@Service
public interface ExaminationService {
    QuizDto startExam(Long id);
}
