package root.human.doctor;

import root.exception.NameInvalidException;
import root.human.doctor.function.IRescue;
import root.human.property.Address;
import root.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Emergency extends Doctor implements IRescue {

    private static int countEmergency;

    private String aid;

    public Emergency(LocalDate dateOfBirth, String name, Address address, Phone phone, String specialty, BigDecimal price) throws NameInvalidException {
        super(dateOfBirth, name, address, phone, specialty, price);
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