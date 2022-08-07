package root.human;

import root.human.properties.Address;
import root.human.properties.Credit;
import root.human.properties.Phone;

import java.time.LocalDate;

public abstract class Human {
    private LocalDate dateOfBirth;
    private String name;
    private Address address;
    private Phone phone;
    private Credit credit;

    public Human(LocalDate dateOfBirth, String name) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
    }

    public Human(LocalDate dateOfBirth, String name, Address address, Phone phone, Credit credit) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.credit = credit;
    }

    public Human(LocalDate dateOfBirth, String name, Address address, Phone phone) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public abstract void think();

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }
}
