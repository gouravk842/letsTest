package com.letsTest.repository;

import com.letsTest.entity.StudentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentAnswerRepo extends JpaRepository<StudentAnswer, Long> {

    @Query("select a from StudentAnswer a where a.quizId=:quizId")
    List<StudentAnswer> getAnswerList(@Param("quizId") Long quizId);

}
