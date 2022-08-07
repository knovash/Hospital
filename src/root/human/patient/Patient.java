package root.human.patient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.human.Human;
import root.human.doctor.Doctor;
import root.human.property.Address;
import root.human.property.Credit;
import root.human.property.Phone;
import root.utils.HospitalUtils;

import java.time.LocalDate;

public class Patient extends Human implements ICure, IRegistrate {
    private static Logger LOGGER = LogManager.getLogger(Patient.class);

    private LocalDate desireedDate;
    private String toDoctor;
    private Appointment appointment;
    private String diagnosis;
    private String prescription;

    public Patient(LocalDate dateOfBirth, String name, Address address, Phone phone, Credit credit, String toDoctor, LocalDate desireedDate) {
        super(dateOfBirth, name, address, phone, credit);
        this.toDoctor = toDoctor;
        this.desireedDate = desireedDate;
    }

    public String toString() {
        return ("Patient: " + super.getName() + " " + super.getCredit().getBalance() + " to " + this.toDoctor + " " + this.desireedDate);
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
                        super.getName().equals(other.getName()) &&
                        super.getAddress().equals(other.getAddress()) &&
                        super.getPhone().equals(other.getPhone());
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
    public void makeAppointment(Doctor[] doctors) {
        LOGGER.info("make appointment to doctor");
        LOGGER.info("patient: " + super.getName() +" to doctor " + this.toDoctor);
        Patient[] patients = new Patient[1];
        patients[0] = this;
        HospitalUtils.match(doctors, patients);
    }
}