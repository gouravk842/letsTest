package com.letsTest.repository;

import com.letsTest.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query("update Answer a set a.questionOption =:newOption where a.answerId=:id")
    void updateAnswerById(@Param("newOption") String newOption, @Param("id") Long id);
}

