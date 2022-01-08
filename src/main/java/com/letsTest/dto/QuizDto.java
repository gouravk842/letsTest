package com.letsTest.dto;

import com.letsTest.entity.Question;

import java.time.LocalDate;
import java.util.List;

public class QuizDto {

    private Long quizId;
    private String nameOfTopic;
    private String description;
    private Long createdById;
    private LocalDate expireDate;
    private Long duration;
    private LocalDate createdDate;
    private List<QuestionDto> question;

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameOfTopic() {
        return nameOfTopic;
    }

    public void setNameOfTopic(String nameOfTopic) {
        this.nameOfTopic = nameOfTopic;
    }

    public Long getCreatedById() {
        return createdById;
    }

    public List<QuestionDto> getQuestion() {
        return question;
    }

    public void setQuestion(List<QuestionDto> question) {
        this.question = question;
    }

}


