package com.letsTest.repository;

import com.letsTest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,Long> {

    @Query("select  s from User s where s.email=:email")
    User findByEmail(@Param("email")String email);


    @Query("select  s from User s where s.userId=:id")
    User getUserById(@Param("id")Long id);

    @Query("select s.userId from User s where s.email=:email")
    Long getIdByEmail(@Param("email")String email);
}
