package com.solvd.hospital.utils;

import com.solvd.hospital.human.patient.Trouble;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hospital.hospital.Hospital;
import com.solvd.hospital.hospital.department.Department;
import com.solvd.hospital.human.doctor.Doctor;
import com.solvd.hospital.human.patient.Patient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HospitalUtils {

    private static final Logger LOGGER = LogManager.getLogger(HospitalUtils.class);

    public static void match(Map<String, Department<? extends Doctor>> departments, List<Patient> patients) {
        LOGGER.info("\nmatching patients and doctors...");
        patients.stream()
                .peek((patient) -> LOGGER.info("\n\n" + patient.toString()))
                .forEach(patient -> patient.getTroubles().stream()
                        .filter(trouble -> trouble.getAppointedDoctor() == null)
                        .forEach(trouble -> matchTrouble(patient, departments)));
    }

    public static void matchTrouble(Patient patient, Map<String, Department<? extends Doctor>> departments) {
        patient.getTroubles().stream()
                .filter(trouble -> trouble.getAppointedDoctor() == null)
                .forEach(trouble ->
                        departments.entrySet().stream()
                                .flatMap(departmentEntry -> departmentEntry.getValue().getDoctors().stream())
                                .filter(doctor -> doctor.getSpec().equals(trouble.getToSpec()))
                                .filter(doctor -> doctor.getGender().equals(patient.getGender()))
                                .filter(doctor -> doctor.getPrice().compareTo(patient.getCredit().getBalance()) == -1)
                                .forEach(doctor -> matchDate(doctor, patient, trouble)));
    }

    public static void matchDate(Doctor doctor, Patient patient, Trouble trouble) {
        LOGGER.info("Spec & Gender & Price matched!");
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

    public static void matchResultPatients(Hospital hospital) {
        LOGGER.info("\n\nPatients match R E S U L T:");
        hospital.getPatients()
                .forEach(patient -> LOGGER.info(patient.getName() + " " + patient.getTroubles()));
    }

    public static void matchResultDoctors(Hospital hospital) {
        LOGGER.info("\n\nDoctors match R E S U L T:");
        hospital.getDepartments().entrySet().stream()
                .flatMap(departmentEntry -> departmentEntry.getValue().getDoctors().stream())
                .forEach(doctor -> {
                    LOGGER.info("  " + doctor + " dates reserved: " + doctor.getReservedDates());
                    LOGGER.info(doctor.getAppointedPatients());
                });
    }

    public static int getExpensiveDoctorsNames(Hospital hospital) {
        List<? extends Doctor> doctors = hospital.getDepartments().get("dnt").getDoctors();
        int result = 0;

        for (Doctor doctor : doctors) {
            if (doctor.getPrice().compareTo(new BigDecimal(500)) == -1) {
                System.out.println("Exp: " + doctor.getName() + " " + doctor.getPrice());
                result++;
            }
        }
        return result;
    }

    public static int getLuxDoctorsNames(Hospital hospital) {
        List<? extends Doctor> doctors = hospital.getDepartments().get("dnt").getDoctors();
        int result = 0;
        for (Doctor doctor : doctors) {
            if (doctor.getPrice().compareTo(new BigDecimal(500)) == 1) {
                System.out.println("Lux: " + doctor.getName() + " " + doctor.getPrice());
                result++;
            }
        }
        return result;
    }

    public static int searchDoctors(Hospital hospital, Searchable s) {
        List<? extends Doctor> doctors = hospital.getDepartments().get("dnt").getDoctors();
        return (int) doctors.stream().filter(doctor -> s.search(doctor))
                .peek(doctor -> System.out.println("----Search: " + doctor.getName() + " " + doctor.getPrice()))
                .count();
    }

    public static Optional<Integer> searchDoctorsOpt(Hospital hospital, Searchable s) {
        List<? extends Doctor> doctors = hospital.getDepartments().get("dnt").getDoctors();
         int result = (int) doctors.stream().filter(doctor -> s.search(doctor))
                .peek(doctor -> System.out.println("----Search: " + doctor.getName() + " " + doctor.getPrice()))
                .count();
         return Optional.ofNullable(result);
    }
}
