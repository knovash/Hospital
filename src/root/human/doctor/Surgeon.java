package root.human.doctor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.exception.InvalidNameException;
import root.human.doctor.function.IOperate;
import root.human.patient.Patient;
import root.human.property.Address;
import root.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Surgeon extends Doctor implements IOperate {

    private static final Logger LOGGER = LogManager.getLogger(Surgeon.class);

    private static int countSurgeon;

    private String operation;

    public Surgeon(LocalDate dateOB, String name, Address address, Phone phone, String specialty, BigDecimal price) throws InvalidNameException {
        super(dateOB, name, address, phone, specialty, price);
        countSurgeon++;
    }

    public Surgeon(String name) {
        super(name);
        countSurgeon++;
    }

    public void think() {
        LOGGER.info("thinks");
    }

    public void doOperation() {
        LOGGER.info("Surgeon do operation");
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public void makeDiagnosis(Patient patient) {
        patient.setDiagnosis("gunshot");
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make diagnosis " + patient.getDiagnosis());
    }

    @Override
    public void makePrescription(Patient patient) {
        patient.setPrescription("aspirin");
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make prescription " + patient.getPrescription());
    }

    @Override
    public void makeOperation() {
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make operation");
    }

    public static int getCountSurgeon() {
        return countSurgeon;
    }

    public static void setCountSurgeon(int countSurgeon) {
        Surgeon.countSurgeon = countSurgeon;
    }
}