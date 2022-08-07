package root.hospital;

import root.hospital.department.Department;
import root.human.Address;
import root.human.Credit;
import root.human.Phone;
import root.human.patient.Patient;

import java.time.LocalDate;

public class Hospital {

    private String name;
    private LocalDate dateOfFoundation;
    private Address address;
    private Phone[] phones;
    private Credit[] credits;
    private Department[] departments;
    private Patient[] patients;


    public Hospital(String name, LocalDate dateOfFoundation, Address address, Phone[] phones, Credit[] credits) {
        this.name = name;
        this.dateOfFoundation = dateOfFoundation;
        this.address = address;
        this.phones = phones;
        this.credits = credits;
    }
    public Hospital() {
    }

    public String toString() {
        return ("Hospital " + this.name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfFoundation() {
        return dateOfFoundation;
    }

    public void setDateOfFoundation(LocalDate dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone[] getPhone() {
        return phones;
    }

    public void setPhone(Phone[] phone) {
        this.phones = phone;
    }

    public Credit[] getCredits() {
        return credits;
    }

    public void setCredits(Credit[] credits) {
        this.credits = credits;
    }

    public Department[] getDepartment() {
        return departments;
    }

    public void setDepartment(Department[] department) {
        this.departments = department;
    }

    public Patient[] getPatient() {
        return patients;
    }

    public void setPatient(Patient[] patient) {
        this.patients = patient;
    }
}