package root.human.doctor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.exception.InvalidNameException;
import root.human.doctor.function.IOperate;
import root.human.patient.Patient;

import java.math.BigDecimal;

public class Surgeon extends Doctor implements IOperate {

    private static final Logger LOGGER = LogManager.getLogger(Surgeon.class);

    private static int countSurgeon;

    private String operation;

    public Surgeon(String name, String specialty, BigDecimal price) throws InvalidNameException {
        super(name, specialty, price);
        countSurgeon++;
    }

    public void think() {
        LOGGER.info("thinks");
    }

    public void doOperation() {
        System.out.println("SURGEON");
        LOGGER.info("Surgeon do operation");
        LOGGER.info(super.getAppointedPatients());
        for (Patient patient : super.getAppointedPatients()) {
            LOGGER.info(patient);
        }
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String makeDiagnosis() {
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make diagnosis");
        return "diagnosis";
    }

    @Override
    public void makePrescription() {
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make prescription");
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