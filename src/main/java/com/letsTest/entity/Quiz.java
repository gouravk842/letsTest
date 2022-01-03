package com.letsTest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;
    private String nameOfTopic;
    private String description;
    private Long createdById;
    private LocalDate expireDate;
    private Long duration;
    private LocalDate createdDate;

}
