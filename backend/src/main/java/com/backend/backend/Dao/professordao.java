package com.backend.backend.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.backend.backend.Entity.professor;

@Repository
public interface professordao extends MongoRepository<professor,Long> {

    @Query("{ 'email': ?0, 'password': ?1 }")
    professor login(String email, String password);
}
