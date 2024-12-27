package com.backend.backend.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    private Long id; 
    private Long profid;
    private Long studentid;
    private LocalTime starttime;
    private LocalTime endtime;
    private LocalDate dateapp;
}
