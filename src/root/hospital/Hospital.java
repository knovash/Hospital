package root.hospital;

import root.hospital.department.Department;
import root.hospital.department.ICalculatePrice;
import root.human.property.Address;
import root.human.property.Credit;
import root.human.property.Phone;
import root.human.patient.Patient;

import java.time.LocalDate;

public class Hospital implements ICalculatePrice {

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

    public String toString() {
        return ("Hospital: " + this.name);
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

    public Phone[] getPhones() {
        return phones;
    }

    public void setPhones(Phone[] phones) {
        this.phones = phones;
    }

    public Credit[] getCredits() {
        return credits;
    }

    public void setCredits(Credit[] credits) {
        this.credits = credits;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    @Override
    public void calculateDoctorsPrice() {

    }
}