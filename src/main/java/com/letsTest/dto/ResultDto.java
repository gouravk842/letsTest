package com.letsTest.dto;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ResultDto {
    private Long quizId;
    private Long createdById;
    private Long totalMarks;
    private String email;
}
