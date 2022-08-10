package root.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.human.patient.Appointment;
import root.human.doctor.Doctor;
import root.human.property.Credit;
import root.human.patient.Patient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class HospitalUtils {

    static final Logger LOGGER = LogManager.getLogger(HospitalUtils.class);

    public static void match(List<Doctor> arrayDoctors, Patient[] arrayPatients) {
        for (int i = 0; i < arrayPatients.length; i++) {
            LOGGER.debug("patient " + arrayPatients[i].getName() + " $" + arrayPatients[i].getCredit().getBalance() + " search for doctor " + arrayPatients[i].getToDoctor());
            Integer index = null;
            for (int j = 0; j < arrayDoctors.size(); j++) {
                if (arrayPatients[i].getToDoctor().equals(arrayDoctors.get(j).getSpecialty())) {
                    LOGGER.debug(arrayDoctors.get(j).getSpecialty() + " " + arrayDoctors.get(j).getName() + " Free from: " + arrayDoctors.get(j).getFreeFromDate());
                    LOGGER.debug("doctor Price: $" + arrayDoctors.get(j).getPrice() + " Credit: $" + arrayPatients[i].getCredit().getBalance());
                    BigDecimal max = arrayDoctors.get(j).getPrice().max(arrayPatients[i].getCredit().getBalance());
                    if (max.compareTo(arrayPatients[i].getCredit().getBalance()) == 0) {
                        LOGGER.debug("Price matched!");
                        if (index == null) {
                            index = j;
                        } else {
                            if (arrayDoctors.get(j).getFreeFromDate().isBefore(arrayDoctors.get(index).getFreeFromDate())) {
                                index = j;
                                LOGGER.debug("Earlier date was found!");
                            }
                        }
                    } else {
                        LOGGER.debug("Appointment rejected");
                    }
                }
            }

            if (index != null) {
                Appointment appointment = new Appointment(arrayDoctors.get(index).getFreeFromDate(), arrayDoctors.get(index), arrayPatients[i], arrayDoctors.get(index).getPrice(), "cabinet");
                arrayPatients[i].setAppointment(appointment);
                LocalDate doctorDate = arrayDoctors.get(index).getFreeFromDate();
                LocalDate doctorDateNew = doctorDate.plusDays(1);
                arrayDoctors.get(index).setFreeFromDate(doctorDateNew);
                arrayDoctors.get(index).appointmentCounter++;
                Credit tmpCredit = arrayPatients[i].getCredit();
                tmpCredit.setBalance(tmpCredit.getBalance().subtract(arrayDoctors.get(index).getPrice()));
                arrayPatients[i].setCredit(tmpCredit);
                LOGGER.debug("");
                LOGGER.info("Appointment accepted: " + arrayPatients[i].getName() + " to " + arrayPatients[i].getToDoctor() + " " + arrayDoctors.get(index).getName() +
                        " Date appointed: " + arrayPatients[i].getAppointment().getDate() + " docAppCount: " + arrayDoctors.get(index).appointmentCounter +
                        " remained " + arrayPatients[i].getCredit().getBalance());
                LOGGER.debug("");
            } else {
                LOGGER.debug("Nothing matched");
                LOGGER.debug("");
            }
        }
    }

    public static void matchResult(Patient[] arrayPatients) {
        for (Patient item : arrayPatients
        ) {
            if (item.getAppointment() != null) {
                LOGGER.info(item.getAppointment().getDate() + " " +
                        item.getAppointment().getPatient().getName() + " to " +
                        item.getAppointment().getDoctor().getSpecialty() + " " +
                        item.getAppointment().getDoctor().getName() + " price " +
                        item.getAppointment().getPrice());
            } else {
                LOGGER.info(item.getName() + " to " + item.getToDoctor() + " nothing matched.");
            }
        }
    }

    public static void print(Doctor[] array) {
        for (Doctor item : array) {
            LOGGER.info(item.getName() + " " + item.getSpecialty() + " " + item.getPrice() + " " + item.getFreeFromDate());
        }
    }

    public static void print(Patient[] array) {
        for (Patient item : array) {
            LOGGER.info(item.getName() + " to " + item.getToDoctor() + " " + item.getDesireedDate() + " $" + item.getCredit().getBalance());
        }
    }
}