package root.human.patient;

import root.human.doctor.Doctor;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Appointment {

    private LocalDate date;
    private Doctor doctor;
    private Patient patient;
    private BigDecimal price;
    private String place;

    public Appointment(LocalDate date, Doctor doctor, Patient patient, BigDecimal price, String place) {
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
        this.price = price;
        this.place = place;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
