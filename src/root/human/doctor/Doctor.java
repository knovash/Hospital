package root.human.doctor;

import root.human.Address;
import root.human.Credit;
import root.human.Human;
import root.human.Phone;

import java.time.LocalDate;

public abstract class Doctor {

    private LocalDate dateOfBirth;
    private String name;
    private Address address;
    private Phone phone;

    private String specialty;
    private LocalDate dateFreeFrom;
    private LocalDate[] dateReserved;
    private int price;
    private Credit credit;
    public int appointmentCounter;
    public static int countDoctor;


    public Doctor() {
         }

    public Doctor(LocalDate dateOfBirth, String name, Address address, Phone phone, String specialty, int price) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.address = address;
        this.phone = phone;
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


    public LocalDate getDateOB() {
        return dateOfBirth;
    }

    public void setDateOB(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddres() {
        return address;
    }

    public void setAddres(Address addres) {
        this.address = addres;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
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

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public int getAppointmentCounter() {
        return appointmentCounter;
    }

    public void setAppointmentCounter(int appointmentCounter) {
        this.appointmentCounter = appointmentCounter;
    }
}
