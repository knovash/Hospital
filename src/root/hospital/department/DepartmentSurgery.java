package root.hospital.department;

import root.human.doctor.Doctor;

import java.math.BigDecimal;

public class DepartmentSurgery extends Department {

    private Doctor[] doctors;

    public DepartmentSurgery(String name) {
        super(name);
    }

    public Doctor[] getDoctor() {
        return doctors;
    }

    public void setDoctor(Doctor[] doctors) {
        this.doctors = doctors;
    }

    @Override
    public void calculateDoctorsPrice() {
        BigDecimal result = new BigDecimal("0");
        for (Doctor doctor:this.getDoctor()
        ) {
            result = result.add(doctor.getPrice());
            System.out.println(doctor.getName() + " " + doctor.getPrice());
        }
        System.out.println(this.getName() + " total price: " + result);
    }
}