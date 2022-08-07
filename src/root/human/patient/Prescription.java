package root.human.patient;

import root.medicine.Medicine;

public class Prescription {
    private Medicine[] medicine;

    public Prescription(Medicine[] medicine) {
        this.medicine = medicine;
    }

    public Medicine[] getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine[] medicine) {
        this.medicine = medicine;
    }
}