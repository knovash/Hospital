package root.human.doctor;

import root.human.properties.Address;
import root.human.properties.Phone;

import java.time.LocalDate;

public class Emergency extends Doctor {
    private String aid;
    public static int countEmergency;

    public Emergency(LocalDate dateOfBirth, String name, Address address, Phone phone, String specialty, int price) {
        super(dateOfBirth, name, address, phone, specialty, price);
        countEmergency++;

    }

    public void think() {
        System.out.println("thinks");
    }

    public void doFirstAid() {
        System.out.println("Emergency do first aid " + this.aid);
    }

    public void makeDiagnosis() {
        System.out.println("Only first aid. for diagnosis please contact the doctor");
    }
}