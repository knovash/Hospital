import java.time.LocalDate;

public class Appointment {

    //fields
    private LocalDate date;
    private Doctor doctor;
    private Patient patient;
    private int price;
    private String place;

    //constructors
    public Appointment(LocalDate date, Doctor doctor, Patient patient, int price, String place) {
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
        this.price = price;
        this.place = place;
    }

    //methods

    //setters and getters

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
