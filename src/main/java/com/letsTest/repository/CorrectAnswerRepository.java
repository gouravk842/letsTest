package com.letsTest.repository;

import com.letsTest.entity.CorrectAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CorrectAnswerRepository extends JpaRepository<CorrectAnswer, Long> {

    //@Query("select a from CorrectAnswer a where a.questionId=:queId and a.quizId=:qzId")
    //List<CorrectAnswer> getCorrectAnswerDetailById(@Param("queId")Long queId,@Param("qzId")Long qzId);
}
