package com.solvd.hospital.hospital.department;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hospital.human.doctor.Doctor;
import com.solvd.hospital.human.doctor.Emergency;

import java.math.BigDecimal;
import java.util.List;

public class DepartmentEmergency<D extends Doctor> extends Department<D> {

    private static final Logger LOGGER = LogManager.getLogger(DepartmentEmergency.class);

    public DepartmentEmergency(String name) {
        super(name);
    }

//    @Override
//    public void calculateDoctorsPrice() {
//        BigDecimal result = new BigDecimal("0");
//        List<D> doctors = super.getDoctor();
//        for (Doctor doctor : doctors) {
//            result = result.add(doctor.getPrice());
//            LOGGER.info(doctor.getName() + " " + doctor.getPrice());
//        }
//        LOGGER.info(this.getName() + " total price: " + result);
//    }
}