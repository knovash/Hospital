package com.solvd.hospital.hospital.department;

import com.solvd.hospital.human.doctor.Doctor;

import java.util.List;

public abstract class Department<D extends Doctor> {

    private String name;
    private List<D> doctor;

    public Department(String name) {
        this.name = name;
    }

    public String toString() {
        return ("Department: " + this.name + " total doctors: " + this.getDoctor().size());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<D> getDoctor() {
        return doctor;
    }

    public void setDoctor(List<D> doctor) {
        this.doctor = doctor;
    }
}