package root.human.doctor;

import root.exception.NameInvalidException;
import root.human.doctor.function.IOperate;
import root.human.property.Address;
import root.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Surgeon extends Doctor implements IOperate {

    private static int countSurgeon;

    private String operation;

    public Surgeon(LocalDate dateOB, String name, Address address, Phone phone, String specialty, BigDecimal price) throws NameInvalidException {
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