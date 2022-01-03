package com.letsTest.dto;

import com.letsTest.entity.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class QuizDto {
    private Long quizId;
    private String nameOfTopic;
    private String description;
    private Long createdById;
    private LocalDate expireDate;
    private Long duration;
    private LocalDate createdDate;
}

