package root.hospital.department;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.human.doctor.Doctor;

import java.util.List;

public abstract class Department implements ICalculatePrice {

    static final Logger LOGGER = LogManager.getLogger(Department.class);

    private String name;
    private List<Doctor> doctors;

    public Department(String name) {
        this.name = name;
    }

    public String toString() {
        return ("Department: " + this.name + " total doctors: ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Doctor> getDoctor() {
        return doctors;
    }

    public void setDoctor(List<Doctor> doctor) {
        this.doctors = doctors;
    }
}