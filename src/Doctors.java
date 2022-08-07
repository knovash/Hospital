import java.time.LocalDate;

public class Doctors {

    //Fields
    private String name;
    private String specialty;
    private LocalDate dataFreeFrom;
    private int price;
    private int countAppointments;
    public static int count = 0;

    //Constructors
    public Doctors(String name, String specialty, int price) {
        this.name = name;
        this.specialty = specialty;
        this.price = price;
        this.countAppointments = 0;
        count++;
        //countPriv++;
    }

    // Methods
    public String print() {
        String text = (this.name + " " + this.specialty + " $" + this.price + " " + this.dataFreeFrom + " " + this.countAppointments);
        return text;
    }


    public void addCounter() {
        this.countAppointments++;
    }


    // Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public LocalDate getDataFreeFrom() {
        return dataFreeFrom;
    }

    public void setDataFreeFrom(LocalDate dataFreeFrom) {
        this.dataFreeFrom = dataFreeFrom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCountAppointments() {
        return countAppointments;
    }

    public void setCountAppointments(int countAppointments) {
        this.countAppointments = countAppointments;
    }
}
