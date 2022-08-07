package root.human.doctor;

import root.human.Human;
import root.human.properties.Address;
import root.human.properties.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Doctor extends Human {
    public static int countDoctor;
    private String specialty;
    private LocalDate dateFreeFrom;
    private LocalDate[] dateReserved;
    private BigDecimal price;
    public int appointmentCounter;

    public Doctor(LocalDate dateOfBirth, String name, Address address, Phone phone, String specialty, BigDecimal price) {
        super(dateOfBirth, name, address, phone);
        this.specialty = specialty;
        this.price = price;
        countDoctor++;
    }

    public String toString() {
        return ("Doctor: " + super.getName() + " " + this.specialty + " " + this.price + " " + this.dateFreeFrom);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Doctor other = (Doctor) object;
        return
        super.getDateOfBirth().equals(other.getDateOfBirth()) &&
        super.getName().equals(other.getName()) &&
        super.getAddress().equals(other.getAddress()) &&
        super.getPhone().equals(other.getPhone()) &&
        this.specialty.equals(other.specialty) &&
        this.dateFreeFrom.equals(other.dateFreeFrom) &&
        //this.dateReserved.equals(other.dateReserved) &&
        this.price.equals(other.price);
    }

    public void makeDiagnosis() {
        System.out.println("Doctor make diagnosis.");
    }

    public void think() {
        System.out.println("thinks");
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public LocalDate getDateFreeFrom() {
        return dateFreeFrom;
    }

    public void setDateFreeFrom(LocalDate dateFreeFrom) {
        this.dateFreeFrom = dateFreeFrom;
    }

    public LocalDate[] getDateReserved() {
        return dateReserved;
    }

    public void setDateReserved(LocalDate[] dateReserved) {
        this.dateReserved = dateReserved;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
