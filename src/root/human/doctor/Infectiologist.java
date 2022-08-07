package root.human.doctor;

import root.human.doctor.function.IAnalyze;
import root.human.property.Address;
import root.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Infectiologist extends Doctor implements IAnalyze {

    private static int countInectiologist;

    private String virus;

    public Infectiologist(LocalDate dateOB, String name, Address address, Phone phone, String specialty, BigDecimal price) {
        super(dateOB, name, address, phone, specialty, price);
        countInectiologist++;
    }

    public void think() {
        LOGGER.info("thinks");
    }


    public void doPullOutTooth() {
        LOGGER.info("Infectiologist disinfect virus");
    }

    public String getVirus() {
        return virus;
    }

    public void setVirus(String virus) {
        this.virus = virus;
    }

    @Override
    public String makeDiagnosis() {
        LOGGER.info( this.getSpecialty() + " " + super.getName() + " make diagnosis");
        return "diagnosis";
    }

    @Override
    public void makePrescription() {
        LOGGER.info( this.getSpecialty() + " " + super.getName() + " make prescription");
    }

    @Override
    public void makeAnalisis() {
        LOGGER.info(super.getName() + " make Analisis");
    }

    public static int getCountInectiologist() {
        return countInectiologist;
    }

    public static void setCountInectiologist(int countInectiologist) {
        Infectiologist.countInectiologist = countInectiologist;
    }
}