package com.letsTest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class QuestionAnswerModel {
    private QuestionDto question;
    private List<AnswerDto> answers;
    private List<CorrectAnswerDto> correctAnswer;
}
