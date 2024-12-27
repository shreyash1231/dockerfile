package com.backend.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.backend.backend.Entity.Appointment;
import com.backend.backend.Entity.Availability;
import com.backend.backend.Service.profservice;
import com.backend.backend.Service.studentservice;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class Studentcontroller {
    @Autowired
    private studentservice stdser;
    @Autowired
    private profservice profser;

    private void checkAuthentication(HttpSession session) {
        if (session.getAttribute("student") == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated.");
        }
    }
    @PostMapping("/appointment")
    public String appointment(@RequestBody Appointment appoint,HttpSession session)
    {
        checkAuthentication(session); 
        appoint.setStudentid((Long)session.getAttribute("student"));
        stdser.appointment(appoint);
        return "Appointment is Booked with Professor";
    }
    @GetMapping("/AvailableProfessor")
    public List<Availability> availprof(HttpSession session)
    {
        checkAuthentication(session);
        return profser.availprof();
    }
}
