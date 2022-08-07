import java.time.LocalDate;

public class Prescription {
    //fields
      private Medicine[] medicine;

    //Constructors
    public Prescription(Medicine[] medicine) {
            this.medicine = medicine;
    }
    //methods

    //setters and getters

    public Medicine[] getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine[] medicine) {
        this.medicine = medicine;
    }
}