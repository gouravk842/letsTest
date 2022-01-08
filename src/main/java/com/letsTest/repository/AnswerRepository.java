package com.letsTest.repository;

import com.letsTest.entity.Answer;
import com.letsTest.entity.Question;
import com.letsTest.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query("update Answer a set a.questionOption =:newOption where a.answerId=:id")
    void updateAnswerById(@Param("newOption") String newOption, @Param("id") Long id);

   // @Query("select a from Answer a where a.questionId=:queId and a.quizId=:qzId")
    //List<Answer> getAnswerDetailById(@Param("queId")Long queId,@Param("qzId")Long qzId);
}

