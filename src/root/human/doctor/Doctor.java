package root.human.doctor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.exception.InvalidNameException;
import root.human.Human;
import root.human.doctor.function.IWrite;
import root.human.patient.Patient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Doctor extends Human implements IWrite {

    private static int countDoctor;

    private String specialty;
    private LocalDate freeFromDate;
    private Set<LocalDate> reservedDates;
    private List<Patient> appointedPatients;
    private BigDecimal price;

    public Doctor(String name, String specialty, BigDecimal price) throws InvalidNameException {
        super(name);
        this.specialty = specialty;
        this.price = price;
        countDoctor++;
    }

    @Override
    public String toString() {
        return ("Doctor: " + super.getName() + " $" + this.price + " " + this.specialty);
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
        return super.getDateOfBirth().equals(other.getDateOfBirth()) && super.getName().equals(other.getName()) && this.specialty.equals(other.specialty) && this.freeFromDate.equals(other.freeFromDate) && this.price.equals(other.price);
    }

    @Override
    public int hashCode() {
        return 31 * super.getDateOfBirth().hashCode() + super.getName().hashCode() + this.specialty.hashCode() + this.freeFromDate.hashCode() + this.price.hashCode();
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
}
