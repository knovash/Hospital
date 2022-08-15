package root.human.doctor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.exception.InvalidNameException;
import root.human.doctor.function.IScreen;

import java.math.BigDecimal;

public class Cardiologist extends Doctor implements IScreen {

    private static final Logger LOGGER = LogManager.getLogger(Cardiologist.class);

    private static int countCardiologist;

    private String ekg;

    public Cardiologist(String name, String specialty, BigDecimal price) throws InvalidNameException {
        super(name, specialty, price);
        countCardiologist++;
    }

    public String makeDiagnosis() {
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make diagnosis");
        return "diagnosis";
    }

    @Override
    public void makePrescription() {
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make prescription");
    }

    @Override
    public void think() {
    }

    public String getEkg() {
        return ekg;
    }

    public void setEkg(String ekg) {
        this.ekg = ekg;
    }

    public static int getCountCardiologist() {
        return countCardiologist;
    }

    public static void setCountCardiologist(int countCardiologist) {
        Cardiologist.countCardiologist = countCardiologist;
    }

    @Override
    public void makeEkg() {
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make cardiogram");
    }
}