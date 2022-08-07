import java.time.LocalDate;

public class Human {

    //Fields
    private LocalDate dateOB;
    private int age;
    private String name;
    private FullName fullName;
    private Address address;
    private Phone phone;
    private String specialty;
    private Credit credit;



    //Constructors
    public Human(LocalDate dateOB, String name) {
        this.dateOB = dateOB;
        this.age = LocalDate.now().getYear() - dateOB.getYear();
        this.name = name;
    }

    // Methods

    // Getters and Setters

    public LocalDate getDateOB() {
        return dateOB;
    }

    public void setDateOB(LocalDate dateOB) {
        this.dateOB = dateOB;
        this.age = LocalDate.now().getYear() - dateOB.getYear();
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }
}
