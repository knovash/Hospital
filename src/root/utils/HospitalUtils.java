package root.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.hospital.Hospital;
import root.hospital.department.Department;
import root.human.doctor.Doctor;
import root.human.patient.Trouble;
import root.human.patient.Patient;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class HospitalUtils {

    private static final Logger LOGGER = LogManager.getLogger(HospitalUtils.class);

    public static void match(Map<String, Department> departments, List<Patient> patients) {
        LOGGER.info("");
        LOGGER.info("matching patients and doctors...");
        for (Patient patient : patients) {
            LOGGER.info("");
            LOGGER.info(patient.toString());
            for (Trouble trouble : patient.getTroubles()) {
                for (Map.Entry<String, Department> entry : departments.entrySet()) {
                    List<Doctor> doctors = entry.getValue().getDoctor();
                    for (Doctor doctor : doctors) {
                        if (trouble.getAppointedDoctor() == null && trouble.getToDoctor().equals(doctor.getSpecialty())) {
                            if (doctor.getPrice().compareTo(patient.getCredit().getBalance()) == -1) {
                                LOGGER.info("Price matched!");
                                LocalDate date = trouble.getDate();
                                if (doctor.getReservedDates() == null) {
                                    doctor.addReservedDates(trouble.getDate());
                                } else {
                                    while (doctor.getReservedDates().contains(date)) {
                                        LOGGER.debug(date + " date in reserved " + doctor.getReservedDates());
                                        date = date.plusDays(1);
                                    }
                                    doctor.getReservedDates().add(date);
                                }
                                doctor.addAppointedPatients(patient);
                                patient.getCredit().addBalance(doctor.getPrice().negate());
                                trouble.setAppointedDoctor(doctor);
                                trouble.setAppointedDate(date);
                                LOGGER.info(patient.getName() + " $" + patient.getCredit().getBalance() + " to " + trouble.getAppointedDoctor());
                                LOGGER.info(doctor.getName() + " " + doctor.getSpecialty() + " " + date + " date added to reserved " + doctor.getReservedDates());
                            } else {
                                LOGGER.info("overprice! " + doctor);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void matchResultPatients(Hospital hospital) {
        LOGGER.info("");
        LOGGER.info("Patients match result:");
        for (Patient patient : hospital.getPatients()) {
            LOGGER.info(patient.getName() + " " + patient.getTroubles());
        }
    }

    public static void matchResultDoctors(Hospital hospital) {
        LOGGER.info("");
        LOGGER.info("Doctors match result:");
        for (Map.Entry<String, Department> entry : hospital.getDepartments().entrySet()) {
            List<Doctor> doctors = entry.getValue().getDoctor();
            for (Doctor doctor : doctors) {
                LOGGER.info("  " + doctor + " dates reserved: " + doctor.getReservedDates());
                LOGGER.info(doctor.getAppointedPatients());
            }
        }
    }
}
