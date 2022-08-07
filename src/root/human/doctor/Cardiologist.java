package root.human.doctor;

import root.human.properties.Address;
import root.human.properties.Phone;

import java.time.LocalDate;

public class Cardiologist extends Doctor {
    private String ekg;
    public static int countCardiologist;

    public Cardiologist(LocalDate dateOB, String name, Address address, Phone phone, String specialty, int price) {
        super(dateOB, name, address, phone, specialty, price);
        countCardiologist++;
    }

    public void doPullOutTooth() {
        System.out.println("Cardiologist make EKG");
    }

    public String getEkg() {
        return ekg;
    }

    public void setEkg(String ekg) {
        this.ekg = ekg;
    }
}