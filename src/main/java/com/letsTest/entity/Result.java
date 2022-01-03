package com.letsTest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Result {
    private Long quizId;
    @Id
    private Long createdId;
    private Long totalMarks;
    private String email;
}
