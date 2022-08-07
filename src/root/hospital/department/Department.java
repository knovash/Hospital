package root.hospital.department;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.human.doctor.Doctor;

public abstract class Department implements ICalculatePrice {
    protected static Logger LOGGER = LogManager.getLogger(Department.class);

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