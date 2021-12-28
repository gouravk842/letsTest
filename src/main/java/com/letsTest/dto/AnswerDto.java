package com.letsTest.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswerDto {
    private Long answerId;
    private Long questionId;
    private String questionOption;
}

