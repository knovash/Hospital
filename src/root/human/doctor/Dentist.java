package root.human.doctor;

import root.human.properties.Address;
import root.human.properties.Phone;

import java.time.LocalDate;

public class Dentist extends Doctor {

    private String tooth;
    public static int countDentist;






   public Dentist(LocalDate dateOfBirth, String name, Address address, Phone phone, String specialty, int price) {
        super(dateOfBirth, name, address, phone, specialty, price);
        countDentist++;
    }

    public void think() {
        System.out.println("thinks");
    }

    public void doPullOutTooth() {
        System.out.println("Dentist pull out tooth");
    }

    public String getTooth() {
        return tooth;
    }

    public void setTooth(String tooth) {
        this.tooth = tooth;
    }
}