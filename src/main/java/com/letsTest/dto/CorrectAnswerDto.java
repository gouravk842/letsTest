package com.letsTest.dto;

import com.letsTest.entity.Answer;
import com.letsTest.entity.Question;

public class CorrectAnswerDto {

    private Long correctAnswerId;
    private Long correctAnswerOptionId;
    private String answer;
    private QuestionDto question;

    public Long getCorrectAnswerId() {
        return correctAnswerId;
    }

    public void setCorrectAnswerId(Long correctAnswerId) {
        this.correctAnswerId = correctAnswerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getCorrectAnswerOptionId() {
        return correctAnswerOptionId;
    }

    public void setCorrectAnswerOptionId(Long correctAnswerOptionId) {
        this.correctAnswerOptionId = correctAnswerOptionId;
    }

    public QuestionDto getQuestion() {
        return question;
    }
    public void setQuestion(QuestionDto question) {
        this.question = question;
    }
}

