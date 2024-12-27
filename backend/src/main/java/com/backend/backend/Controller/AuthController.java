package com.backend.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.backend.backend.Entity.professor;
import com.backend.backend.Entity.student;
import com.backend.backend.Service.serservice;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/authController")
public class AuthController{
    @Autowired
    private serservice servi;
    private void checknullstudentvalue(student std) {
        if (std.getEmail()==null||std.getPassword()==null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated.");
        }
    } 
    private void checknullprofessorvalue(professor prof) {
        if (prof.getEmail()==null||prof.getPassword()==null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated.");
        }
    }
    @PostMapping("/studentsignup")
    public String stdsignup(@RequestBody student std) {
        if(std.getName()==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Fill All the data");
        }
        checknullstudentvalue(std);
        servi.stdsignup(std);
        return "Data Saved Successfully";
    }
    
    @PostMapping("/studentlogin")
    public String stdlogin(@RequestBody student std,HttpSession session)
    {
        checknullstudentvalue(std);
        student st = servi.stdlogin(std);
        checknullstudentvalue(st);
        session.setAttribute("student", st.getStudent_id());
        return "Login Successfully";
    }
    @PostMapping("/professorsignup")
    public String profsignup(@RequestBody professor prof,HttpSession session) {
        if(prof.getName()==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Fill All the data");
        }
        checknullprofessorvalue(prof);
        session.setAttribute("professorname", prof.getName());
        servi.profsignup(prof);
        return "Data Saved Successfully";
    }
    
    @PostMapping("/professorlogin")
    public String proflogin(@RequestBody professor prof,HttpSession session)
    {
        checknullprofessorvalue(prof);
        professor pr = servi.proflogin(prof);
        checknullprofessorvalue(pr);
        session.setAttribute("professor", pr.getProf_id());
        return "Login Successfully";
    }
}
