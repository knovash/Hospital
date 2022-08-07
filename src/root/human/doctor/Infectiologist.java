package root.human.doctor;

import root.human.properties.Address;
import root.human.properties.Phone;

import java.time.LocalDate;

public class Infectiologist extends Doctor {
    private String virus;
    public static int countInectiologist;

    public Infectiologist(LocalDate dateOB, String name, Address address, Phone phone, String specialty, int price) {
        super(dateOB, name, address, phone, specialty, price);
        countInectiologist++;
    }

    public void think() {
        System.out.println("thinks");
    }

    public void doPullOutTooth() {
        System.out.println("Infectiologist disinfect virus");
    }
}