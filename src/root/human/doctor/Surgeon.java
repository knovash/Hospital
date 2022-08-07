package root.human.doctor;

import root.human.Address;
import root.human.Phone;

import java.time.LocalDate;

public class Surgeon extends Doctor {
    private String operation;
    public static int countSurgeon;

    public Surgeon(LocalDate dateOB, String name, Address address, Phone phone, String specialty, int price) {
        super(dateOB, name, address, phone, specialty, price);
        countSurgeon++;
    }

    public void doOperation() {
        System.out.println("Surgeon do operation");
    }
}