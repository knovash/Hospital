package root.human.doctor;

import root.human.doctor.function.IOperate;
import root.human.property.Address;
import root.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Surgeon extends Doctor implements IOperate {

    private static int countSurgeon;

    private String operation;

    public Surgeon(LocalDate dateOB, String name, Address address, Phone phone, String specialty, BigDecimal price) {
        super(dateOB, name, address, phone, specialty, price);
        countSurgeon++;
    }

    public Surgeon(String name) {
        super(name);
        countSurgeon++;
    }

    public void think() {
        System.out.println("thinks");
    }

    public void doOperation() {
        System.out.println("Surgeon do operation");
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String makeDiagnosis() {
        System.out.println(this.getSpecialty() + " " + super.getName() + " make diagnosis");
        return "diagnosis";
    }

    @Override
    public void makePrescription() {
        System.out.println(this.getSpecialty() + " " + super.getName() + " make prescription");
    }

    @Override
    public void makeOperation() {

    }

    public static int getCountSurgeon() {
        return countSurgeon;
    }

    public static void setCountSurgeon(int countSurgeon) {
        Surgeon.countSurgeon = countSurgeon;
    }
}