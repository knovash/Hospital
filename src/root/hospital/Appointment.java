package root.hospital;

import root.human.doctor.Doctor;
import root.human.patient.Patient;

import javax.print.Doc;
import java.time.LocalDate;

public class Appointment {

    private LocalDate date;
    private Doctor doctor;
    private Patient patient;

    public Appointment(LocalDate date, Doctor doctor, Patient patient) {
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
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
}
