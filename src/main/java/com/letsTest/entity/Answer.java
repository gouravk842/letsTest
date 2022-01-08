package com.letsTest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Answer {

    private Long answerId;
    private Long answerOrder;
    private String questionOption;
    private Question questions;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="questionId")
    @JsonIgnore
    public Question getQuestions() {
        return questions;
    }
    public void setQuestions(Question questions) {
        this. questions= questions;
    }



}

