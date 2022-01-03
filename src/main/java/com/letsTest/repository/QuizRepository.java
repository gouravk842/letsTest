package com.letsTest.repository;


import com.letsTest.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("QuizRepository")
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Modifying(clearAutomatically = true)
    @javax.transaction.Transactional
    @Query("update Quiz q set q.nameOfTopic =:newTopic  where q.quizId=:id")
    void updateQuizById(@Param("newTopic") String newTopic,@Param("id") Long id);

    @Query("select q from Quiz q where q.createdById=:id")
    List<Quiz> getQuizDetailById(@Param("id")Long id);

}
