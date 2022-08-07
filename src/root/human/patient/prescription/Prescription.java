package root.human.patient.prescription;

import root.human.patient.prescription.procedure.Procedure;
import root.human.patient.prescription.medicine.Medicine;

public class Prescription {
    private Medicine[] medicines;
    private Procedure[] procedures;

    public Prescription(Medicine[] medicines, Procedure[] procedures) {
        this.medicines = medicines;
        this.procedures = procedures;
    }

    public Medicine[] getMedicines() {
        return medicines;
    }

    public void setMedicines(Medicine[] medicines) {
        this.medicines = medicines;
    }

    public Procedure[] getProcedures() {
        return procedures;
    }

    public void setProcedures(Procedure[] procedures) {
        this.procedures = procedures;
    }
}