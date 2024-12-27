package com.backend.backend.Dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.backend.Entity.Availability;

@Repository
public interface Availabilitydao extends MongoRepository<Availability,Long> {

    @Query(value = "{}", fields = "{'profId': 1, 'startTime': 1, 'endTime': 1, 'status': 1, 'name': 1, 'dateAvail': 1}")
    List<Availability> availprof();

    @Query("{'profId': ?3, 'startTime': ?1, 'endTime': ?2, 'dateAvail': ?0}")
    List<Availability> finddata(LocalDate dateAvail, LocalTime startTime, LocalTime endTime, Long profId);

    default void updatestatus(String status, LocalDate dateAvail, LocalTime startTime, LocalTime endTime, Long profId) {
        List<Availability> record = finddata(dateAvail, startTime, endTime, profId);
        for (int i = 0; i < record.size(); i++) {
            Availability avail = record.get(i);
            avail.setStatus(status);
        }
        saveAll(record);
    }
}
