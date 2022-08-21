package com.solvd.hospital.human.doctor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hospital.exception.InvalidNameException;
import com.solvd.hospital.human.doctor.function.IAnalyze;

import java.math.BigDecimal;

public class Infectiologist extends Doctor implements IAnalyze {

    private static final Logger LOGGER = LogManager.getLogger(Infectiologist.class);

    private static int countInectiologist;

    private String virus;

    public Infectiologist(String name, String specialty, Spec spec, BigDecimal price) throws InvalidNameException {
        super(name, specialty, spec, price);
        countInectiologist++;
    }

    public void think() {
        LOGGER.info("thinks");
    }

    public String getVirus() {
        return virus;
    }

    public void setVirus(String virus) {
        this.virus = virus;
    }

    @Override
    public String makeDiagnosis() {
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make diagnosis");
        return "diagnosis";
    }

    @Override
    public void makePrescription() {
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make prescription");
    }

    @Override
    public void makeAnalisis() {
        LOGGER.info(super.getName() + " make Analisis" + this.virus);
    }

    public static int getCountInectiologist() {
        return countInectiologist;
    }

    public static void setCountInectiologist(int countInectiologist) {
        Infectiologist.countInectiologist = countInectiologist;
    }
}