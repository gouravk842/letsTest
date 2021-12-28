package com.letsTest.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class QuizDto {
    private Long quizId;
    private String nameOfTopic;
    private String description;
    private Long createdById;
}

