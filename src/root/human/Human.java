package root.human;

import java.time.LocalDate;

public abstract class Human {

    private LocalDate dateOfBirth;
    private int age;
    private String name;
    private Address address;
    private Phone phone;
    private Credit credit;

    public Human(LocalDate dateOfBirth, String name) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
    }

    public void run() {
        System.out.println("Human run");
    }

    public LocalDate getDateOB() {
        return dateOfBirth;
    }

    public void setDateOB(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.age = LocalDate.now().getYear() - dateOfBirth.getYear();
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
