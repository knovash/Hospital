package root.human.doctor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.exception.InvalidNameException;
import root.human.doctor.function.IScreen;
import root.human.patient.Patient;
import root.human.property.Address;
import root.human.property.Phone;
import root.medicine.procedure.ProcedureExternal;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cardiologist extends Doctor implements IScreen {

    private static final Logger LOGGER = LogManager.getLogger(Cardiologist.class);

    private static int countCardiologist;

    private String ekg;

    public Cardiologist(LocalDate dateOfBirth, String name, Address address, Phone phone, String specialty, BigDecimal price) throws InvalidNameException {
        super(dateOfBirth, name, address, phone, specialty, price);
        countCardiologist++;
    }

    public Cardiologist(String name) {
        super(name);
        countCardiologist++;
    }

    @Override
    public void makeDiagnosis(Patient patient) {
        patient.setDiagnosis("heart attak");
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make diagnosis " + patient.getDiagnosis());
    }

    @Override
    public void makePrescription(Patient patient) {
        patient.setPrescription("validol");
        ProcedureExternal procedure = new ProcedureExternal("xxx", "desc", new BigDecimal(100));
        patient.setProcedure(procedure);
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make prescription " + patient.getPrescription());
    }

    @Override
    public void think() {
    }

    public void doEkg() {
        LOGGER.info("Cardiologist make cardiogram");
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