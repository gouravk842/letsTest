package com.letsTest.dto;

import com.letsTest.entity.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
public class AnswerDto {
    private Long answerId;
    private Long questionId;
    private Long quizId;
    private String questionOption;

}

