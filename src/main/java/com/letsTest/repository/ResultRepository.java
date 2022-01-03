package com.letsTest.repository;

import com.letsTest.entity.Answer;
import com.letsTest.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    @Query("select r from Result r where r.quizId=:qzId and r.createdById=:creById")
    List<Result> getResultDetailById(@Param("creById")Long creById, @Param("qzId")Long qzId);
}
