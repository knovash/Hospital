package root.human.doctor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.exception.InvalidNameException;
import root.human.doctor.function.IAnalyze;

import java.math.BigDecimal;

public class Infectiologist extends Doctor implements IAnalyze {

    private static final Logger LOGGER = LogManager.getLogger(Infectiologist.class);

    private static int countInectiologist;

    private String virus;

    public Infectiologist(String name, String specialty, BigDecimal price) throws InvalidNameException {
        super(name, specialty, price);
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