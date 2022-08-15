package com.solvd.hospital.human;

import com.solvd.hospital.exception.InvalidNameException;
import com.solvd.hospital.exception.DateInvalidException;
import com.solvd.hospital.human.property.Address;
import com.solvd.hospital.human.property.Credit;
import com.solvd.hospital.human.property.Phone;

import java.time.LocalDate;

public abstract class Human {

    private LocalDate dateOfBirth;
    private String name;
    private Address address;
    private Phone phone;
    private Credit credit;

    public Human(LocalDate dateOfBirth, String name, Address address, Phone phone, Credit credit) {

        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.credit = credit;
    }

    public Human(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ("Human: " + this.name + " " + this.dateOfBirth.toString());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Human other = (Human) object;
        return this.dateOfBirth.equals(other.dateOfBirth) && this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return 31 * this.dateOfBirth.hashCode() + this.name.hashCode();
    }

    public abstract void think();

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new DateInvalidException("Invalid date in the future.");
        }
        if (dateOfBirth.isBefore(LocalDate.now().minusYears(150))) {
            throw new DateInvalidException("Invalid date is too in past.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidNameException {
        if (name.contains("_")) {
            throw new InvalidNameException("Human name contain (_)");
        }
        if (name.contains(" ")) {
            throw new InvalidNameException("Human name contain ( )");
        }
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
