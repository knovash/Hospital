package root.human.patient;

import root.human.Address;
import root.human.Credit;
import root.human.Human;
import root.human.Phone;

import java.time.LocalDate;

public class Patient {

        //Fields
        private LocalDate dateOfBirth;
        private int age;
        private String name;

        private Address address;
        private Phone phone;
        private LocalDate desireedDate;
        //private LocalDate dateAppointed;
        private String toDoctor;
        private Credit credit;
        private Appointment appointment;
        private Prescription prescription;
        private Human[] childrens;
        static int totalAppointments;


        //Constructors


    public Patient(LocalDate dateOfBirth, String name, Address address, Phone phone, Credit credit, String toDoctor, LocalDate desireedDate) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.credit = credit;
        this.toDoctor = toDoctor;
        this.desireedDate = desireedDate;
        this.age = LocalDate.now().getYear() - dateOfBirth.getYear();
    }

        // Methods

        // Getters and Setters


    public LocalDate getDateOB() {
        return dateOfBirth;
    }

    public void setDateOB(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.age = LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public LocalDate getDateDesired() {
        return desireedDate;
    }

    public void setDateDesired(LocalDate desireedDate) {
        this.desireedDate = desireedDate;
    }

    public String getToDoctor() {
        return toDoctor;
    }

    public void setToDoctor(String toDoctor) {
        this.toDoctor = toDoctor;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
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
