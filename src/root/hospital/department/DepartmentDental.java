package root.hospital.department;

import root.human.doctor.Doctor;

public class DepartmentDental extends Department {
    private Doctor[] doctors;

    public DepartmentDental(String name) {
        super(name);
    }

    public Doctor[] getDoctor() {
        return doctors;
    }

    public void setDoctor(Doctor[] doctors) {
        this.doctors = doctors;
    }

}