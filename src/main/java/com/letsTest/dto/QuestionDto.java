package com.letsTest.dto;

import com.letsTest.entity.Answer;
import com.letsTest.entity.Quiz;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
public class QuestionDto {
    private Long questionId;
    private Long quizId;
    private String question;
    private String hint;


}