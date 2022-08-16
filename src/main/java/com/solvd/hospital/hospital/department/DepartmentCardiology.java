package com.solvd.hospital.hospital.department;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hospital.human.doctor.Cardiologist;
import com.solvd.hospital.human.doctor.Doctor;

import java.math.BigDecimal;
import java.util.List;

public class DepartmentCardiology<D extends Doctor> extends Department<D> {

    private static final Logger LOGGER = LogManager.getLogger(DepartmentCardiology.class);

    public DepartmentCardiology(String name) {
        super(name);
    }

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
