package com.letsTest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class CorrectAnswer {

    private Long correctAnswerId;
    private Long correctAnswerOptionId;
    private String answer;
    private Question question;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="questionId")
    @JsonIgnore
    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
}
