package com.letsTest.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QuestionDto {
    private Long questionId;
    private Long quizId;
    private String question;
    private String hint;
    private String correctAnswer;
}
