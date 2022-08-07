package root.human.doctor;

import root.human.doctor.function.Analysis;
import root.human.property.Address;
import root.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Infectiologist extends Doctor implements Analysis {

    public static int countInectiologist;

    private String virus;

    public Infectiologist(LocalDate dateOB, String name, Address address, Phone phone, String specialty, BigDecimal price) {
        super(dateOB, name, address, phone, specialty, price);
        countInectiologist++;
    }

    public void think() {
        System.out.println("thinks");
    }


    public void doPullOutTooth() {
        System.out.println("Infectiologist disinfect virus");
    }

    public String getVirus() {
        return virus;
    }

    public void setVirus(String virus) {
        this.virus = virus;
    }

    @Override
    public String makeDiagnosis() {
        System.out.println( this.getSpecialty() + " " + super.getName() + " make diagnosis");
        return "diagnosis";
    }

    @Override
    public void makePrescription() {
        System.out.println( this.getSpecialty() + " " + super.getName() + " make prescription");
    }

    @Override
    public void makeAnalisis() {

    }
}