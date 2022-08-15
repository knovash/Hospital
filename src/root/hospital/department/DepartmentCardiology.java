package root.hospital.department;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.human.doctor.Doctor;

import java.math.BigDecimal;

public class DepartmentCardiology extends Department {

    private static final Logger LOGGER = LogManager.getLogger(DepartmentCardiology.class);

    private Doctor[] doctors;

    public DepartmentCardiology(String name) {
        super(name);
    }

    public void calculateDoctorsPrice() {
        BigDecimal result = new BigDecimal("0");
        for (Doctor doctor:this.getDoctor()
        ) {
            result = result.add(doctor.getPrice());
            LOGGER.info(doctor.getName() + " " + doctor.getPrice());
        }
        LOGGER.info(this.getName() + " total price: " + result);
    }

     public Doctor[] getDoctor() {
        return doctors;
    }

    public void setDoctor(Doctor[] doctors) {
        this.doctors = doctors;
    }
}