package root.human.doctor;

import root.human.Address;
import root.human.Phone;

import java.time.LocalDate;

public class Dentist extends Doctor {

    private String tooth;
    public static int countDentist;

    public Dentist() {

    }




   public Dentist(LocalDate dateOfBirth, String name, Address address, Phone phone, String specialty, int price) {
        super(dateOfBirth, name, address, phone, specialty, price);
        countDentist++;
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