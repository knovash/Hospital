import java.time.LocalDate;

public class Doctor {

    //Fields
    private LocalDate dateOB;
    private String name;
    private FullName fullName;
    private Address address;
    private Phone phone;

    private String specialty;
    private LocalDate dateFreeFrom;
    private LocalDate[] dateReserved;
    private int price;
    private Credit credit;
    public int appointmentCounter;


    //Constructors
    public Doctor(LocalDate dateOB, String name, Address address, Phone phone, String specialty, int price) {
        this.dateOB = dateOB;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.specialty = specialty;
        this.price = price;
    }

    // Methods

    // Getters and Setters


    public LocalDate getDateOB() {
        return dateOB;
    }

    public void setDateOB(LocalDate dateOB) {
        this.dateOB = dateOB;
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
