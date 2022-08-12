package root.human.doctor;

import root.exception.InvalidNameException;
import root.human.doctor.function.IRescue;

import java.math.BigDecimal;

public class Emergency extends Doctor implements IRescue {

    private static int countEmergency;

    private String aid;

    public Emergency(String name, String specialty, BigDecimal price) throws InvalidNameException {
        super(name, specialty, price);
        countEmergency++;
    }

    public void think() {
        LOGGER.info("thinks");
    }

    public void doFirstAid() {
        LOGGER.info("Emergency do first aid " + this.aid);
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
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make first aid");
    }
}