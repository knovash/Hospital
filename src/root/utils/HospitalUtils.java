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

    static final Logger LOGGER = LogManager.getLogger(HospitalUtils.class);

    public static void match(Map<String, Department> departments, List<Patient> patients) {
        LOGGER.info("");
        LOGGER.info("matching patients and doctors...");
        for (Patient patient : patients) {
            LOGGER.info("");
            LOGGER.info(patient.toString());
            for (Trouble trouble : patient.getTroubles()) {
                for (Map.Entry<String, Department> entry : departments.entrySet()) {
                    Department department = entry.getValue();
                    for (Doctor doctor : department.getDoctor()) {
                        if (trouble.getAppointedDoctor() == null && trouble.getToDoctor().equals(doctor.getSpecialty())) {
                            if (doctor.getPrice().compareTo(patient.getCredit().getBalance()) == -1) {
                                LOGGER.info(">> " + doctor + " reserved dates: " + doctor.getReservedDates().toString());
                                LOGGER.debug("Price matched!");
                                LocalDate date = trouble.getDate();
                                while (doctor.getReservedDates().contains(date)) {
                                    LOGGER.debug(date + " date in reserved " + doctor.getReservedDates());
                                    date = date.plusDays(1);
                                }
                                doctor.getReservedDates().add(trouble.getDate());
                                doctor.getAppointedPatients().add(patient);
                                patient.getCredit().addBalance(doctor.getPrice().negate());
                                trouble.setAppointedDoctor(doctor);
                                trouble.setAppointedDate(date);
                                LOGGER.info(patient.getName() + " to " + trouble.getAppointedDoctor());
                                LOGGER.info(doctor.getName() + " " + doctor.getSpecialty() + " " + trouble.getDate() + " date added to reserved " + doctor.getReservedDates());
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
            LOGGER.info(patient.getName() + " to " + patient.getTroubles());
        }
    }

    public static void matchResultDoctors(Hospital hospital) {
        LOGGER.info("");
        LOGGER.info("Doctors match result:");
        for (Map.Entry<String, Department> entry : hospital.getDepartments().entrySet()) {
            Department department = entry.getValue();
            LOGGER.info(department);
            for (Doctor doctor : department.getDoctor()) {
                LOGGER.info("  " + doctor + " dates reserved: " + doctor.getReservedDates());
                LOGGER.info(doctor.getAppointedPatients());
            }
        }
    }
}
