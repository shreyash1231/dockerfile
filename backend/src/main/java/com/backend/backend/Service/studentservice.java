package com.backend.backend.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.Dao.Appointementdao;
import com.backend.backend.Dao.Availabilitydao;
import com.backend.backend.Dao.professordao;
import com.backend.backend.Entity.Appointment;
import com.backend.backend.Entity.Availability;

@Service
public class studentservice {
    @Autowired
    private Appointementdao appointdao;
    @Autowired
    private Availabilitydao availdao;
    public void appointment(Appointment appoint) {
        appointdao.save(appoint);
        List<Availability> records = availdao.updatestatus(appoint.getProfid(), appoint.getStarttime(), appoint.getEndtime(), appoint.getDateapp());
        String status = "Slot is Booked";
        
        if (!records.isEmpty()) {
            records.forEach(record -> {
                record.setStatus(status);
            });
            availdao.saveAll(records);
        }
    }
    
}
    
