import java.time.LocalDate;

public class Hospital {

    //Fields
    private String name;
    private String address;
    private String phone;

    private Doctor doctor;
    private Patient patient;
    private Medicine medicine;
    public int credit;


    //Constructors
    public Hospital(String name, String address, String phone, int credit) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.credit = credit;
    }



    // Methods
    public void print(){
        System.out.println("Hospital name: " + this.name + " address: " + this.address + " credit: " + this.credit);
    }

    // Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}