package com.solvd.hospital.hospital.department;

import com.solvd.hospital.human.doctor.Doctor;

import java.util.List;

public abstract class Department<D extends Doctor> {

    private String name;
    private Dep dep;
    private List<D> doctors;

    public Department(String name, Dep dep) {
        this.name = name;
        this.dep = dep;
    }

    public String toString() {
        return ("Department: " + " " + this.dep.getDisplayName() + " total doctors: " + this.getDoctors().size());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<D> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<D> doctors) {
        this.doctors = doctors;
    }
}