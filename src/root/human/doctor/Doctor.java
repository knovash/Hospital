package root.human.doctor;

import root.human.Human;
import root.human.properties.Address;
import root.human.properties.Credit;
import root.human.properties.Phone;

import java.time.LocalDate;

public abstract class Doctor extends Human {

    private String specialty;
    private LocalDate dateFreeFrom;
    private LocalDate[] dateReserved;
    private int price;
    public int appointmentCounter;
    public static int countDoctor;


    public Doctor(LocalDate dateOfBirth, String name, Address address, Phone phone, String specialty, int price) {
        super(dateOfBirth, name, address, phone);
        this.specialty = specialty;
        this.price = price;
        countDoctor++;
    }


    public void makePrescription() {
        System.out.println("Doctor make prescription.");
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public int getAppointmentCounter() {
        return appointmentCounter;
    }

    public void setAppointmentCounter(int appointmentCounter) {
        this.appointmentCounter = appointmentCounter;
    }
}
