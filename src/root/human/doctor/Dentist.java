package root.human.doctor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.exception.InvalidNameException;
import root.human.doctor.function.ITooth;
import root.human.patient.Patient;
import root.human.property.Address;
import root.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Dentist extends Doctor implements ITooth {

    private static final Logger LOGGER = LogManager.getLogger(Dentist.class);

    private static int countDentist;

    private String tooth;

    public Dentist(LocalDate dateOfBirth, String name, Address address, Phone phone, String specialty, BigDecimal price) throws InvalidNameException {
        super(dateOfBirth, name, address, phone, specialty, price);
        countDentist++;
    }

    public void think() {
        LOGGER.info("thinks");
    }

    public void makeDiagnosis(Patient patient) {
        patient.setDiagnosis("toothache");
        LOGGER.info( this.getSpecialty() + " " + super.getName() + " make diagnosis " + patient.getDiagnosis());
    }

    @Override
    public void makePrescription(Patient patient) {
        patient.setPrescription("paracetomol");
        LOGGER.info( this.getSpecialty() + " " + super.getName() + " make prescription " + patient.getPrescription());
    }

    public void doPullOutTooth() {
        LOGGER.info("Dentist pull out tooth");
    }

    public String getTooth() {
        return tooth;
    }

    public void setTooth(String tooth) {
        this.tooth = tooth;
    }

    public static int getCountDentist() {
        return countDentist;
    }

    public static void setCountDentist(int countDentist) {
        Dentist.countDentist = countDentist;
    }

    @Override
    public void makeDentalFilling() {
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make dental filling");
    }

    @Override
    public void makePullOutTooth() {
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make pull out tooth");
    }
}