package root;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import root.exception.DateException;
import root.hospital.Hospital;
import root.hospital.department.*;
import root.exception.NameException;
import root.human.property.Phone;
import root.human.doctor.*;
import root.human.patient.Patient;
import root.utils.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.debug("log debug");
        LOGGER.info("log info");
        LOGGER.error("log error");
        LOGGER.warn("log warn");
        // create hospital
        Hospital hospital = ToolHospital.create();
        LOGGER.info("Create hospital:");
        LOGGER.info(hospital);
        LOGGER.info(hospital.getAddress().toString());
        for (Phone item : hospital.getPhones()) {
            LOGGER.info(item.toString());
        }
        // create doctors
        Cardiologist[] cardiologists = new ToolDoctor().createCardiologist();
        Dentist[] dentists = new ToolDoctor().createDentist();
        Emergency[] emergencys = new ToolDoctor().createEmergency();
        Infectiologist[] infectiologysts = new ToolDoctor().createInfectioligist();
        Surgeon[] surgeons = new ToolDoctor().createSurgeon();
        // create departments
        Department[] departments = new ToolDepartment().create();
        // set doctors to departments
        departments[0].setDoctor(cardiologists);
        departments[1].setDoctor(dentists);
        departments[2].setDoctor(emergencys);
        departments[3].setDoctor(infectiologysts);
        departments[4].setDoctor(surgeons);
        // set departments to hospital
        hospital.setDepartments(departments);
        // set doctors date free from now
        LOGGER.info("");
        LOGGER.info("doctors:");
        for (Department department : hospital.getDepartments()) {
            LOGGER.info(department.toString());
            for (Doctor doctor : department.getDoctor()) {
                doctor.setFreeFromDate(LocalDate.now());
                LOGGER.debug("  " + doctor.toString());
            }
        }
        // create patients
        Patient[] patients = new ToolPatient().create();
        hospital.setPatients(patients);
        LOGGER.info("");
        LOGGER.info("patients:");
        for (Patient patient : hospital.getPatients()) {
            LOGGER.info(patient.toString());
        }

//        // match patients and doctors
        LOGGER.info("");
        LOGGER.info("matching patients and doctors...");
        LOGGER.info("");
        for (Department department : hospital.getDepartments()) {
            LOGGER.debug(department.toString());
            HospitalUtils.match(department.getDoctor(), hospital.getPatients());
        }

        LOGGER.info("");
        LOGGER.info("match result:");
        HospitalUtils.matchResult(hospital.getPatients());

        // test interface
//        LOGGER.debug("interface");
//        Patient patient = hospital.getPatients()[0];
//        Doctor[] docs = hospital.getDepartments()[1].getDoctor();
//        patient.makeAppointment(docs);  // (Doctors[], Patient[0])

        // test try catch
        LOGGER.info("test 1 try");

//        patients[0].setToDoctor("NewName");
        patients[0].setName("NewN_ame"); //uncheck
//        patients[0].setDateOfBirth(LocalDate.now().minusYears(200)); //check
        LOGGER.info("test 2 try");
        try {
            patients[0].setName("NewName");
            patients[0].setToDoctor("NewToDoc");
//            System.out.println(3/0);
            patients[0].setDateOfBirth(LocalDate.now().minusYears(200));
        } catch (NameException e) {
            LOGGER.error("catch NameException e.getMessage, e = " + e.getMessage(), e);
        }catch (DateException e) {
            LOGGER.error("catch DateException e.getMessage, e = " + e.getMessage(), e);
        }
        catch (Exception e) {
            LOGGER.error("catch Exception e.getMessage, e = " + e.getMessage(), e);
        } finally {
            LOGGER.info("Event error in Patient: ");
        }




        System.out.println("sys.out name: " + patients[0].getName());

//        LOGGER.info("test 2 try");
//        try {
//            patients[0].setDateOfBirth(LocalDate.now().minusYears(200));
//        } catch (DateException e) {
//            LOGGER.error("e.getMessage, e = " + e.getMessage(), e);
//        }
//
//        LOGGER.info("test 3 try");
//        try {
//            patients[0].setDateOfBirth(LocalDate.now().plusYears(2));
//        } catch (DateException e) {
//            LOGGER.error("e.getMessage, e = " + e.getMessage(), e);
//        }
//
//        LOGGER.info("test 4 try");
//        try {
//            patients[0].setDateOfBirth(LocalDate.now().minusYears(20));
//        } catch (DateException e) {
//            LOGGER.error("e.getMessage, e = " + e.getMessage(), e);
//        }

    }
}