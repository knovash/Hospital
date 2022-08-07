package root.human.patient;

import root.human.Human;
import root.human.doctor.Doctor;
import root.human.patient.prescription.Prescription;
import root.human.properties.Address;
import root.human.properties.Credit;
import root.human.properties.Phone;

import java.time.LocalDate;

public class Patient extends Human {
    private LocalDate desireedDate;
    private String toDoctor;
    private Appointment appointment;
    private Prescription prescription;

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
        if (super.getName().equals(other.getName())) {
        } else {
            System.out.println("not equal: name ");
            return false;
        }
        if (super.getAddress().equals(other.getAddress())) {
        } else {
            System.out.println("not equal: address ");
            return false;
        }
        if (super.getPhone().equals(other.getPhone())) {
        } else {
            System.out.println("not equal: phone ");
            return false;
        }
        if (this.getCredit().equals(other.getCredit())) {
        } else {
            System.out.println("not equal: credit ");
            return false;
        }
        if (this.desireedDate.equals(other.desireedDate)) {
        } else {
            System.out.println("not equal: date ");
            return false;
        }
        if (this.toDoctor.equals(other.toDoctor)) {
        } else {
            System.out.println("not equal: doctor ");
            return false;
        }
        return true;
//                super.getDateOfBirth().equals(other.getDateOfBirth()) &&
//                super.getName().equals(other.getName()) &&
//                super.getAddress().equals(other.getAddress()) &&
//                super.getPhone().equals(other.getPhone()) &&
//                super.getCredit().equals(other.getCredit()) &&
//                this.desireedDate.equals(other.desireedDate) &&
//                this.toDoctor.equals(other.toDoctor);
    }

    public void think() {
        System.out.println("Patient thinks");
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

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}