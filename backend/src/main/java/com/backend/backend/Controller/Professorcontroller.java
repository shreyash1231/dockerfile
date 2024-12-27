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

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/professor")
public class Professorcontroller {

    @Autowired 
    private profservice profser;
    private void checkAuthentication(HttpSession session) {
        if (session.getAttribute("professor") == null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated.");
        }
    }
    @PostMapping("/Availability")
    public String avail(@RequestBody Availability av,HttpSession session)
    {
        checkAuthentication(session);
        Long no = (Long)session.getAttribute("professor");
        av.setName((String)session.getAttribute("professorname"));
        av.setStatus("Time slot is not Booked");
        av.setProfid(no);
        profser.avail(av);
        return "Data Saved";
    }
    @GetMapping("/getstudentdata")
    public List<Appointment> getstudentdata(HttpSession session)
    {
        checkAuthentication(session);
        return profser.getstudentdata();
    }
}
