import java.time.LocalDate;

public class Hospital {

    //Fields
    private String name;
    private LocalDate dateOfFoundation;
    private Address address;
    private Phone[] phone;
    private Credit[] credits;
    private Department[] department;
    private Patient[] patient;


    //Constructors
    public Hospital(String name, LocalDate dateOfFoundation, Address address, Phone[] phone, Credit[] credits) {
        this.name = name;
        this.dateOfFoundation = dateOfFoundation;
        this.address = address;
        this.phone = phone;
        this.credits = credits;
    }

    public Hospital() {
    }

    // Methods

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfFoundation() {
        return dateOfFoundation;
    }

    public void setDateOfFoundation(LocalDate dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone[] getPhone() {
        return phone;
    }

    public void setPhone(Phone[] phone) {
        this.phone = phone;
    }

    public Credit[] getCredits() {
        return credits;
    }

    public void setCredits(Credit[] credits) {
        this.credits = credits;
    }

    public Department[] getDepartment() {
        return department;
    }

    public void setDepartment(Department[] department) {
        this.department = department;
    }

    public Patient[] getPatient() {
        return patient;
    }

    public void setPatient(Patient[] patient) {
        this.patient = patient;
    }
}