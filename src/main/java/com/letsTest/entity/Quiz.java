package com.letsTest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Quiz {

    private Long quizId;
    private String nameOfTopic;
    private String description;
    private Long createdById;
    private LocalDate expireDate;
    private Long duration;
    private LocalDate createdDate;
    private List<Question> question;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
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


    @OneToMany(targetEntity=Question.class, mappedBy="quiz", cascade = {CascadeType.ALL})
    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

}
