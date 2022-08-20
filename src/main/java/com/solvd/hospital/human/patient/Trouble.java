package com.solvd.hospital.human.patient;

import com.solvd.hospital.human.doctor.Doctor;

import java.time.LocalDate;

public class Trouble {

    private LocalDate date;
    private String toDoctor;
    private LocalDate appointedDate;
    private Doctor appointedDoctor;

    public Trouble(LocalDate date, String toDoctor) {
        this.date = date;
        this.toDoctor = toDoctor;
    }

    @Override
    public String toString() {
        return date + " " + toDoctor + " >> " + appointedDate + " " + appointedDoctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getToDoctor() {
        return toDoctor;
    }

    public void setToDoctor(String toDoctor) {
        this.toDoctor = toDoctor;
    }

    public LocalDate getAppointedDate() {
        return appointedDate;
    }

    public void setAppointedDate(LocalDate appointedDate) {
        this.appointedDate = appointedDate;
    }

    public Doctor getAppointedDoctor() {
        return appointedDoctor;
    }

    public void setAppointedDoctor(Doctor appointedDoctor) {
        this.appointedDoctor = appointedDoctor;
    }
}
