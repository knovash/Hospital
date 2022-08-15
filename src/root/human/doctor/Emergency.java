package root.human.doctor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.exception.InvalidNameException;
import root.human.doctor.function.IRescue;
import root.human.patient.Patient;
import root.human.property.Address;
import root.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Emergency extends Doctor implements IRescue {

    private static final Logger LOGGER = LogManager.getLogger(Emergency.class);

    private static int countEmergency;

    private String aid;

    public Emergency(LocalDate dateOfBirth, String name, Address address, Phone phone, String specialty, BigDecimal price) throws InvalidNameException {
        super(dateOfBirth, name, address, phone, specialty, price);
        countEmergency++;
    }

    public void think() {
        LOGGER.info("thinks");
    }

    public void doFirstAid() {
        LOGGER.info("Emergency do first aid " + this.aid);
    }

    public void makeDiagnosis(Patient patient) {
        patient.setDiagnosis("heart attak");
        LOGGER.info( this.getSpecialty() + " " + super.getName() + " make diagnosis " + patient.getDiagnosis());
    }

    @Override
    public void makePrescription(Patient patient) {
        patient.setPrescription("heart attak");
        LOGGER.info( this.getSpecialty() + " " + super.getName() + " make prescription " + patient.getPrescription());
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