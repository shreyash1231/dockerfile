package com.backend.backend.Service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.Dao.Appointementdao;
import com.backend.backend.Dao.Availabilitydao;
import com.backend.backend.Dao.professordao;
import com.backend.backend.Entity.Appointment;

@Service
public class studentservice {

    @Autowired
    private Appointementdao appdao;

    @Autowired
    private Availabilitydao availdao;
    public void appointment(Appointment appoint) {
        availdao.updatestatus("Time Slot Booked",appoint.getDateapp(),appoint.getStarttime(),appoint.getEndtime(),appoint.getProfid());
        appdao.save(appoint);
    }
    
}
