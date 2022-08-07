package root.human;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.exception.NameInvalidException;
import root.exception.runtime.DateInvalidException;
import root.human.property.Address;
import root.human.property.Credit;
import root.human.property.Phone;

import java.time.LocalDate;

public abstract class Human {

    private static Logger LOGGER = LogManager.getLogger(Human.class);

    private LocalDate dateOfBirth;
    private String name;
    private Address address;
    private Phone phone;
    private Credit credit;

    public Human(LocalDate dateOfBirth, String name) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
    }

    public Human(LocalDate dateOfBirth, String name, Address address, Phone phone, Credit credit)  {

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
        int result = this.dateOfBirth.hashCode() + this.name.hashCode();
        return result;
    }

    public abstract void think();

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) throws DateInvalidException {
//        LOGGER.error("Human set date throw Invalid date: " + dateOfBirth.toString());
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


    public void setName(String name) throws NameInvalidException {
        //LOGGER.error("Human setname. Invalid char in name: " + this.name);
        if (name.contains("_")) {
            throw new NameInvalidException("Human name contain (_)");
        }
        if (name.contains(" ")) {
            throw new NameInvalidException("Human name contain ( )");
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
