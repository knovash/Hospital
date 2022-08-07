package root.hospital.department;

import root.human.doctor.Doctor;
import root.utils.ToolDepartment;

public abstract class Department implements TotalPrice {

    private String name;
    private Doctor[] doctors;

    public Department(String name) {
        this.name = name;
    }

    public String toString() {
        return ("Department: " + this.name + " total doctors: " + this.getDoctor().length);
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