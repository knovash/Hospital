package root.hospital.department;

import root.human.doctor.Doctor;

public abstract class Department {

    private String name;
    private Doctor[] doctors;
    private Department[] subDepartment;

    public Department(String name) {
        this.name = name;
    }


    public void Report() {
        System.out.println("Department report:");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doctor[] getDoctor() {
        return doctors;
    }

    public void setDoctor(Doctor[] doctor) {
        this.doctors = doctors;
    }
}