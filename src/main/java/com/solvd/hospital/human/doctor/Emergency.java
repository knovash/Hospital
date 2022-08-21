package com.solvd.hospital.human.doctor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hospital.exception.InvalidNameException;
import com.solvd.hospital.human.doctor.function.IRescue;

import java.math.BigDecimal;

public class Emergency extends Doctor implements IRescue {

    private static final Logger LOGGER = LogManager.getLogger(Emergency.class);

    private static int countEmergency;

    private String aid;

    public Emergency(String name, String specialty, Spec spec, BigDecimal price) throws InvalidNameException {
        super(name, specialty, spec, price);
        countEmergency++;
    }

    public void think() {
        LOGGER.info("thinks");
    }

    public String makeDiagnosis() {
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make diagnosis");
        return "diagnosis";
    }

    @Override
    public void makePrescription() {
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make prescription");
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public static int getCountEmergency() {
        return countEmergency;
    }

    public static void setCountEmergency(int countEmergency) {
        Emergency.countEmergency = countEmergency;
    }

    @Override
    public void makeFirstAid() {
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make first aid" + this.aid);
    }
}