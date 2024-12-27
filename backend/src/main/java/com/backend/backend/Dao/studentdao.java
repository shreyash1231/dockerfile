package com.backend.backend.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.backend.backend.Entity.student;

@Repository
public interface studentdao extends MongoRepository<student,Long> {

    @Query("{ 'email': ?0, 'password': ?1 }")
    student login(String email, String password);
}
