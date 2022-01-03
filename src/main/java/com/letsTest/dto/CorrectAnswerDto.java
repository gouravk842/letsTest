package com.letsTest.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Setter
@Getter
public class CorrectAnswerDto {

    private Long correctAnswerId;
    private Long questionId;
    private Long quizId;
}
