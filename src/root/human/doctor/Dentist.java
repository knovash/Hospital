package root.human.doctor;

import root.human.doctor.function.ITooth;
import root.human.property.Address;
import root.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Dentist extends Doctor implements ITooth {

    private static int countDentist;

    private String tooth;

    public Dentist(LocalDate dateOfBirth, String name, Address address, Phone phone, String specialty, BigDecimal price) {
        super(dateOfBirth, name, address, phone, specialty, price);
        countDentist++;
    }

    public void think() {
        System.out.println("thinks");
    }

    public String makeDiagnosis() {
        System.out.println(this.getSpecialty() + " " + super.getName() + " make diagnosis");
        return "diagnosis";
    }

    @Override
    public void makePrescription() {
        System.out.println(this.getSpecialty() + " " + super.getName() + " make prescription");
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

    public static int getCountDentist() {
        return countDentist;
    }

    public static void setCountDentist(int countDentist) {
        Dentist.countDentist = countDentist;
    }

    @Override
    public void makeDentalFilling() {

    }

    @Override
    public void makePullOutTooth() {

    }
}