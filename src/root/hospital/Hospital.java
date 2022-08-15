package root.hospital;

import root.exception.ArrayEmptyException;
import root.exception.ArrayOneElementException;
import root.hospital.department.Department;
import root.hospital.department.ICalculatePrice;
import root.human.property.Address;
import root.human.property.Credit;
import root.human.property.Phone;
import root.human.patient.Patient;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Hospital implements ICalculatePrice {

    private String name;
    private LocalDate dateOfFoundation;
    private Address address;
    private List<Phone> phones;
    private List<Credit> credits;
    private Map<String, Department> departments;
    private List<Patient> patients;

    public Hospital(String name, LocalDate dateOfFoundation, Address address, List<Phone> phones, List<Credit> credits) {
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

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public Map<String, Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, Department> departments) {
        this.departments = departments;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) throws ArrayOneElementException {
        if (patients.size() == 0) {
            throw new ArrayEmptyException("patients array is 0");
        }
        if (patients.size() == 1) {
            this.patients = patients;
            throw new ArrayOneElementException("patients only one");
        }
        this.patients = patients;
    }

    @Override
    public void calculateDoctorsPrice() {

    }
}