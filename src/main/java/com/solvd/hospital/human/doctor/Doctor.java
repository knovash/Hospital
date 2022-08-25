package com.solvd.hospital.human.doctor;

import com.solvd.hospital.exception.InvalidNameException;
import com.solvd.hospital.human.Human;
import com.solvd.hospital.human.doctor.function.IWrite;
import com.solvd.hospital.utils.Searchable;
import com.solvd.hospital.human.patient.Patient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Doctor extends Human implements IWrite, Searchable {

    private static int countDoctor;

    private String specialty;
    private LocalDate freeFromDate;
    private Set<LocalDate> reservedDates;
    private List<Patient> appointedPatients;
    private BigDecimal price;
    private Spec spec;

    public Doctor(String name, String specialty, Spec spec, BigDecimal price) throws InvalidNameException {
        super(name);
        this.specialty = specialty;
        this.spec = spec;
        this.price = price;
        countDoctor++;
    }

    @Override
    public String toString() {
        return ("Doctor: " + super.getName() + " " + super.getGender().getDisplayName() + " $" + this.price + " " + this.spec.getDisplayName());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Doctor other = (Doctor) object;
        return super.getDateOfBirth().equals(other.getDateOfBirth()) && super.getName().equals(other.getName()) && this.specialty.equals(other.specialty) && this.spec.equals(other.spec) && this.freeFromDate.equals(other.freeFromDate) && this.price.equals(other.price);
    }

    @Override
    public int hashCode() {
        return 31 * super.getDateOfBirth().hashCode() + super.getName().hashCode() + this.specialty.hashCode() + this.spec.hashCode() + this.freeFromDate.hashCode() + this.price.hashCode();
    }

    public abstract String makeDiagnosis();

    public abstract void makePrescription();

    public void addReservedDates(LocalDate date) {
        if (this.reservedDates == null) {
            this.reservedDates = new HashSet<>();
        }
        this.reservedDates.add(date);
    }

    public void addAppointedPatients(Patient patient) {
        if (this.appointedPatients == null) {
            this.appointedPatients = new ArrayList<>();
        }
        this.appointedPatients.add(patient);
    }

    public boolean search(Doctor doctor) {
        return doctor.getPrice().compareTo(new BigDecimal(500)) == -1;
    }

    public static int getCountDoctor() {
        return countDoctor;
    }

    public static void setCountDoctor(int countDoctor) {
        Doctor.countDoctor = countDoctor;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public LocalDate getFreeFromDate() {
        return freeFromDate;
    }

    public void setFreeFromDate(LocalDate freeFromDate) {
        this.freeFromDate = freeFromDate;
    }

    public Set<LocalDate> getReservedDates() {
        return reservedDates;
    }

    public void setReservedDates(Set<LocalDate> reservedDates) {
        this.reservedDates = reservedDates;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Patient> getAppointedPatients() {
        return appointedPatients;
    }

    public void setAppointedPatients(List<Patient> appointedPatients) {
        this.appointedPatients = appointedPatients;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }
}
