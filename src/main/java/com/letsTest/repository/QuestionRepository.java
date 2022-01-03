package com.letsTest.repository;


import com.letsTest.entity.Question;
import com.letsTest.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("QuestionRepository")
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("update Question q set q.question =:newQuestion where q.questionId=:id")
    void updateQuestionById(@Param("newQuestion") String newQuestion, @Param("id") Long id);

    @Query("select q from Question q where q.quizId=:id")
    List<Question> getQuestionDetailById(@Param("id")Long id);

}

