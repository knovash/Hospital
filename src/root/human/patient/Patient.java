package root.human.patient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.exception.DateInvalidException;
import root.exception.InvalidNameException;
import root.hospital.Appointment;
import root.human.Human;
import root.human.doctor.Doctor;
import root.human.property.Address;
import root.human.property.Credit;
import root.human.property.Phone;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Human implements ICure, IRegistrate {

    static final Logger LOGGER = LogManager.getLogger(Patient.class);

    private LocalDate desireedDate;
    private String toDoctor;
    private Appointment appointment;
    private String diagnosis;
    private String prescription;
    private Doctor appointedDoctor;
    private List<Trouble> troubles;

    public Patient(LocalDate dateOfBirth, String name, Address address, Phone phone, Credit credit, String toDoctor, LocalDate desireedDate) throws InvalidNameException {
        super(dateOfBirth, name, address, phone, credit);
        if (super.getDateOfBirth().isBefore(LocalDate.now().minusYears(150))) {
            throw new DateInvalidException(super.getName() + " Human dob is too in past " + super.getDateOfBirth());
        }
        if (super.getName().contains("_")) {
            super.setName(super.getName().replace("_", "-"));
            this.toDoctor = toDoctor;
            this.desireedDate = desireedDate;
            LOGGER.info("in name (_) replaced by (-)");
        }
        if (super.getName().contains(" ")) {
            throw new InvalidNameException(super.getName() + " Human name contain ( ) ");
        }
        if (toDoctor.contains("_")) {
            throw new InvalidNameException(super.getName() + " Patient to Doctor contain (_) " + toDoctor);
        }
        if (desireedDate.isBefore(LocalDate.now())) {
            throw new DateInvalidException(super.getName() + " Patient desiered date in past " + desireedDate);
        }
        this.toDoctor = toDoctor;
        this.desireedDate = desireedDate;
        this.troubles = new ArrayList<>();
    }

    public String toString() {
        return ("Patient: " + super.getName() + " $" + super.getCredit().getBalance() + " to " + this.troubles);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Patient other = (Patient) object;
        return
                super.getDateOfBirth().equals(other.getDateOfBirth()) &&
                        super.getName().equals(other.getName());
    }

    public int hashCode() {
        int result = super.getDateOfBirth().hashCode() +
                super.getName().hashCode() +
                super.getAddress().hashCode() +
                super.getPhone().hashCode();
        return result;
    }

    public void think() {
        LOGGER.info("Patient thinks");
    }

    public LocalDate getDesireedDate() {
        return desireedDate;
    }

    public void setDesireedDate(LocalDate desireedDate) {
        this.desireedDate = desireedDate;
    }

    public void plusDesireedDate() {
        this.desireedDate = this.desireedDate.plusDays(1);
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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public List<Trouble> getTroubles() {
        return troubles;
    }

    public void setTroubles(List<Trouble> troubles) {
        this.troubles = troubles;
    }

    public Doctor getAppointedDoctor() {
        return appointedDoctor;
    }

    public void setAppointedDoctor(Doctor appointedDoctor) {
        this.appointedDoctor = appointedDoctor;
    }

    @Override
    public void takePill() {
        LOGGER.info(super.getName() + " take pill");
    }

    @Override
    public void takeInjection() {
        LOGGER.info(super.getName() + " take injection");
    }

    @Override
    public void takeProcedure() {
        LOGGER.info(super.getName() + " take procedure");
    }

    @Override
    public void getInHospital() {
        LOGGER.info(super.getName() + " get in hospital");
    }

    @Override
    public void getOutHospital() {
        LOGGER.info(super.getName() + " get out hospital");
    }

    @Override
    public void makeAppointment(List<Doctor> doctors) {
        LOGGER.info("make appointment to doctor");
        LOGGER.info("patient: " + super.getName() + " to doctor " + this.toDoctor);
    }
}