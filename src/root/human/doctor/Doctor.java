package root.human.doctor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.exception.NameInvalidException;
import root.human.Human;
import root.human.doctor.function.IWrite;
import root.human.property.Address;
import root.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Doctor extends Human implements IWrite {
    protected static Logger LOGGER = LogManager.getLogger(Doctor.class);

    private static int countDoctor;

    private String specialty;
    private LocalDate freeFromDate;
    private LocalDate[] reservedDates;
    private BigDecimal price;
    public int appointmentCounter;

    public Doctor(String name) {
        super(name);
        countDoctor++;
    }

    public Doctor(LocalDate dateOfBirth, String name, Address address, Phone phone, String specialty, BigDecimal price)  throws NameInvalidException {
        super(dateOfBirth, name, address, phone);
        this.specialty = specialty;
        this.price = price;
        countDoctor++;
    }

    @Override
    public String toString() {
        return ("Doctor: " + super.getName() + " " + this.specialty + " " + this.price + " " + this.freeFromDate);
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
        return
                super.getDateOfBirth().equals(other.getDateOfBirth()) &&
                        super.getName().equals(other.getName()) &&
                        this.specialty.equals(other.specialty) &&
                        this.freeFromDate.equals(other.freeFromDate) &&
                        this.price.equals(other.price);
    }

    @Override
    public int hashCode() {
        int result = super.getDateOfBirth().hashCode() +
                super.getName().hashCode() +
                this.specialty.hashCode() +
                this.freeFromDate.hashCode() +
                this.price.hashCode();
        return result;
    }

    public abstract String makeDiagnosis();

    public abstract void makePrescription();

    public abstract void think();
    //{
    //LOGGER.info("thinks");
    //}

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

    public LocalDate[] getReservedDates() {
        return reservedDates;
    }

    public void setReservedDatesd(LocalDate[] reservedDates) {
        this.reservedDates = reservedDates;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static int getCountDoctor() {
        return countDoctor;
    }

    public static void setCountDoctor(int countDoctor) {
        Doctor.countDoctor = countDoctor;
    }

    public void setReservedDates(LocalDate[] reservedDates) {
        this.reservedDates = reservedDates;
    }

    public int getAppointmentCounter() {
        return appointmentCounter;
    }

    public void setAppointmentCounter(int appointmentCounter) {
        this.appointmentCounter = appointmentCounter;
    }
}
