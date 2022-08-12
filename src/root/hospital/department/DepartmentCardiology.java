package root.hospital.department;

import root.human.doctor.Doctor;

import java.math.BigDecimal;

public class DepartmentCardiology extends Department {

    public DepartmentCardiology(String name) {
        super(name);
    }

    public void calculateDoctorsPrice() {
        BigDecimal result = new BigDecimal("0");
        for (Doctor doctor : this.getDoctor()) {
            result = result.add(doctor.getPrice());
            LOGGER.info(doctor.getName() + " " + doctor.getPrice());
        }
        LOGGER.info(this.getName() + " total price: " + result);
    }
}
