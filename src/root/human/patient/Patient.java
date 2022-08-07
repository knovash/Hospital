package root.human.patient;


import root.human.Human;
import root.human.patient.prescription.Prescription;
import root.human.properties.Address;
import root.human.properties.Credit;
import root.human.properties.Phone;

import java.time.LocalDate;

public class Patient extends Human{

    private LocalDate desireedDate;
    //private LocalDate dateAppointed;
    private String toDoctor;
    private Appointment appointment;
    private Prescription prescription;



    public Patient(LocalDate dateOfBirth, String name, Address address, Phone phone, Credit credit, String toDoctor, LocalDate desireedDate) {
        super(dateOfBirth, name, address, phone, credit);
        this.toDoctor = toDoctor;
        this.desireedDate = desireedDate;
    }

    public void think() {
        System.out.println("Patient thinks");
    }

    public LocalDate getDesireedDate() {
        return desireedDate;
    }

    public void setDesireedDate(LocalDate desireedDate) {
        this.desireedDate = desireedDate;
    }

    public String getToDoctor() {
        return toDoctor;
    }

    public void setToDoctor(String toDoctor) {
        this.toDoctor = toDoctor;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}