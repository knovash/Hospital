package root.human.doctor;
import root.human.doctor.function.Cardiogram;
import root.human.property.Address;
import root.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cardiologist extends Doctor implements Cardiogram {

    private String ekg;
    public static int countCardiologist;

    public Cardiologist(LocalDate dateOfBirth, String name, Address address, Phone phone, String specialty, BigDecimal price) {
        super(dateOfBirth, name, address, phone, specialty, price);
        countCardiologist++;
    }

    public Cardiologist(String name) {
        super(name);
        countCardiologist++;
    }

    public String makeDiagnosis() {
        System.out.println( this.getSpecialty() + " " + super.getName() + " make diagnosis");
        return "diagnosis";
    }


    @Override
    public void makePrescription() {
        System.out.println( this.getSpecialty() + " " + super.getName() + " make prescription");


    }

    @Override
    public void think() {

    }

    public void doEkg() {
        System.out.println("Cardiologist make cardiogram");
    }

    public String getEkg() {
        return ekg;
    }

    public void setEkg(String ekg) {
        this.ekg = ekg;
    }

    @Override
    public void makeEkg() {

    }
}