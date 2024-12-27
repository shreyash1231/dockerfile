package com.backend.backend.Entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "avail_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Availability {
    @Id
    private Long avail_id;
    private Long profid;
    private String name;
    private LocalTime starttime;
    private LocalTime endtime;
    private LocalDate date_avail;
    private String Status;
}
