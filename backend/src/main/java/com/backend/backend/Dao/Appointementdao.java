package com.backend.backend.Dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import com.backend.backend.Entity.Appointment;

@Repository
public interface Appointementdao extends MongoRepository<Appointment,Long> {

    @Query("{}") 
    List<Appointment> getstudentdata();
}
