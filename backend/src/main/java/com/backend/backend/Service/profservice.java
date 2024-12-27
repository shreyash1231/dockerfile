package com.backend.backend.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.Dao.Appointementdao;
import com.backend.backend.Dao.Availabilitydao;
import com.backend.backend.Entity.Appointment;
import com.backend.backend.Entity.Availability;

@Service
public class profservice {

    @Autowired
    private Availabilitydao availdao;
    @Autowired
    private Appointementdao appdao;
    public void avail(Availability av) {
       availdao.save(av);
    }

    public List<Availability> availprof() {
       return availdao.availprof();
    }

    public List<Appointment> getstudentdata() {
       return appdao.getstudentdata();
    }
    
}
