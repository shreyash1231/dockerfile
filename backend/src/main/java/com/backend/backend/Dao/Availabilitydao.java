package com.backend.backend.Dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.backend.Entity.Availability;

@Repository
public interface Availabilitydao extends MongoRepository<Availability,Long> {
    @Query("{'profid': ?0, 'starttime': ?1, 'endtime': ?2, 'date_avail': ?3}")
    List<Availability> updatestatus(Long profid, String starttime, String endtime, String dateapp);
}
