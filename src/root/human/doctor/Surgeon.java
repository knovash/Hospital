package root.human.doctor;

import root.human.properties.Address;
import root.human.properties.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Surgeon extends Doctor {
    private String operation;
    public static int countSurgeon;

    public Surgeon(LocalDate dateOB, String name, Address address, Phone phone, String specialty, BigDecimal price) {
        super(dateOB, name, address, phone, specialty, price);
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
}