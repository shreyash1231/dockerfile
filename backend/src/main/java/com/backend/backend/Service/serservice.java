package com.backend.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.Dao.professordao;
import com.backend.backend.Dao.studentdao;
import com.backend.backend.Entity.professor;
import com.backend.backend.Entity.student;

@Service
public class serservice{

    @Autowired
    private studentdao stddao;
    @Autowired
    private professordao profdao;

    public void profsignup(professor prof) {
        profdao.save(prof);
    }

    public professor proflogin(professor prof) {
        return profdao.login(prof.getEmail(),prof.getPassword());
    }

    public void stdsignup(student std) {
       stddao.save(std);
    }

    public student stdlogin(student std) {
       return stddao.login(std.getEmail(),std.getPassword());
    }
    
}
