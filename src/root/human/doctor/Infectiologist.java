package root.human.doctor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.exception.InvalidNameException;
import root.human.doctor.function.IAnalyze;
import root.human.patient.Patient;
import root.human.property.Address;
import root.human.property.Phone;
import root.medicine.procedure.ProcedureExternal;
import root.medicine.procedure.ProcedureInternal;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Infectiologist extends Doctor implements IAnalyze {

    private static final Logger LOGGER = LogManager.getLogger(Infectiologist.class);

    private static int countInectiologist;

    private String virus;

    public Infectiologist(LocalDate dateOB, String name, Address address, Phone phone, String specialty, BigDecimal price) throws InvalidNameException {
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
    public void makeDiagnosis(Patient patient) {
        patient.setDiagnosis("infection");
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make diagnosis " + patient.getDiagnosis());
    }

    @Override
    public void makePrescription(Patient patient) {
        patient.setPrescription("tabletki");
        ProcedureInternal procedure = new ProcedureInternal("xxx", "desc", new BigDecimal(100));
        patient.setProcedure(procedure);
        LOGGER.info(this.getSpecialty() + " " + super.getName() + " make prescription " + patient.getPrescription());
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