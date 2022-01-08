package com.letsTest.dto;

import java.util.List;

public class AnswerDto {

    private Long answerId;
    private String questionOption;
    private QuestionDto questions;
    private Long answerOrder;


    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(String questionOption) {
        this.questionOption = questionOption;
    }

    public Long getAnswerOrder() {
        return answerOrder;
    }

    public void setAnswerOrder(Long answerOrder) {
        this.answerOrder = answerOrder;
    }

    public QuestionDto getQuestions() {
        return questions;
    }
    public void setQuestions(QuestionDto question) {
        this. questions= question;
    }


}


