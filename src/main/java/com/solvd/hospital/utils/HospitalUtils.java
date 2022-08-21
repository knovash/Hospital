package com.solvd.hospital.utils;

import com.solvd.hospital.human.doctor.Dentist;
import com.solvd.hospital.human.doctor.function.Searchable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hospital.hospital.Hospital;
import com.solvd.hospital.hospital.department.Department;
import com.solvd.hospital.human.doctor.Doctor;
import com.solvd.hospital.human.patient.Trouble;
import com.solvd.hospital.human.patient.Patient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class HospitalUtils {

    private static final Logger LOGGER = LogManager.getLogger(HospitalUtils.class);

    public static void match(Map<String, Department<? extends Doctor>> departments, List<Patient> patients) {
        LOGGER.info("");
        LOGGER.info("matching patients and doctors...");
        for (Patient patient : patients) {
            LOGGER.info("");
            LOGGER.info(patient.toString());
            for (Trouble trouble : patient.getTroubles()) {
                for (Map.Entry<String, Department<? extends Doctor>> entry : departments.entrySet()) {
                    List<? extends Doctor> doctors = entry.getValue().getDoctors();
                    for (Doctor doctor : doctors) {
                        if (trouble.getAppointedDoctor() == null
                                && trouble.getToSpec().equals(doctor.getSpec())
                                && patient.getGender().equals(doctor.getGender())
                                && doctor.getPrice().compareTo(patient.getCredit().getBalance()) == -1) {
                            LOGGER.info("Spec matched!" + trouble.getToSpec() + " = " + doctor.getSpec());
                            LOGGER.info("Gender matched!" + patient.getGender() + " = " + doctor.getGender());
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
        for (Map.Entry<String, Department<? extends Doctor>> entry : hospital.getDepartments().entrySet()) {
            List<? extends Doctor> doctors = entry.getValue().getDoctors();
            for (Doctor doctor : doctors) {
                LOGGER.info("  " + doctor + " dates reserved: " + doctor.getReservedDates());
                LOGGER.info(doctor.getAppointedPatients());
            }
        }
    }

    public static int getExpensiveDoctorsNames(Hospital hospital) {
        List<? extends Doctor> dentists = hospital.getDepartments().get("dnt").getDoctors();
        int result = 0;
        for (Doctor doctor : dentists) {
            if (doctor.getPrice().compareTo(new BigDecimal(500)) == -1) {
                System.out.println("Exp: " + doctor.getName() + " " + doctor.getPrice());
                result++;
            }
        }
        return result;
    }

    public static int getLuxDoctorsNames(Hospital hospital) {
        List<? extends Doctor> dentists = hospital.getDepartments().get("dnt").getDoctors();
        int result = 0;
        for (Doctor doctor : dentists) {
            if (doctor.getPrice().compareTo(new BigDecimal(500)) == 1) {
                System.out.println("Lux: " + doctor.getName() + " " + doctor.getPrice());
                result++;
            }
        }
        return result;
    }

    public static int getSearchDoctorsNames(Hospital hospital, Searchable s) {
        List<? extends Doctor> dentists = hospital.getDepartments().get("dnt").getDoctors();
        int result = 0;
        for (Doctor doctor : dentists) {
            if (s.search(doctor)) {
                System.out.println("Search: " + doctor.getName() + " " + doctor.getPrice());
                result++;
            }
        }
        return result;
    }

    public static int getDoctorsNamesContains(Hospital hospital) {
        List<? extends Doctor> dentists = hospital.getDepartments().get("dnt").getDoctors();
        int result = 0;
        for (Doctor doctor : dentists) {
            if (doctor.getName().contains("a")) {
                System.out.println("Contain: " + doctor.getName());
                result++;
            }
        }
        return result;
    }
}
