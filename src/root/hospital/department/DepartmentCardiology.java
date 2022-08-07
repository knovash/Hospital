package root.hospital.department;

import root.hospital.Hospital;
import root.human.doctor.Doctor;

import java.math.BigDecimal;

public class DepartmentCardiology extends Department {

    private Doctor[] doctors;
    private Hospital hospital;

    public DepartmentCardiology(String name) {
        super(name);
    }

    public void calculateDoctorsPrice(){
//        LOGGER.info(doctors[0].toString());
        LOGGER.info(hospital.getDepartments()[0].getDoctor());
        BigDecimal result = new BigDecimal("0");
//        for (Doctor doctor:super.getDoctor()
//        ) {
//            result = result.add(doctor.getPrice());
//            LOGGER.info(doctor.getName() + " " + doctor.getPrice());
//        }
        LOGGER.info(this.getName() + " total price: " + result);
    }


     public Doctor[] getDoctor() {
        return doctors;
    }

    public void setDoctor(Doctor[] doctors) {
        this.doctors = doctors;
    }
}