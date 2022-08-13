package root;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import root.exception.*;
import root.hospital.Hospital;
import root.hospital.department.*;
import root.human.property.Phone;
import root.human.doctor.*;
import root.human.patient.Patient;
import root.utils.*;

import java.time.LocalDate;
import java.util.*;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.debug("test logger debug");
        LOGGER.info("test logger info");
        LOGGER.error("test logger error");

        // create hospital
        Hospital hospital = ToolHospital.create();
        LOGGER.debug("Create hospital:");
        LOGGER.info(hospital);
        LOGGER.info(hospital.getAddress().toString());
        for (Phone item : hospital.getPhones()) {
            LOGGER.info(item.toString());
        }
        // create doctors
        List<Doctor> cardiologists;
        List<Doctor> dentists;
        List<Doctor> emergencys;
        List<Doctor> infectiologysts;
        List<Doctor> surgeons;
        try {
            cardiologists = new ToolDoctor().createCardiologist();
            dentists = new ToolDoctor().createDentist();
            emergencys = new ToolDoctor().createEmergency();
            infectiologysts = new ToolDoctor().createInfectiologist();
            surgeons = new ToolDoctor().createSurgeon();
        } catch (InvalidNameException e) {
            throw new RuntimeException(e);
        }

        // create patients and set to hospital
        List<Patient> patients;
        try {
            patients = new ToolPatient().createPatient();
            hospital.setPatients(patients);
        } catch (InvalidNameException e) {
            throw new RuntimeException(e);
        } catch (ArrayOneElementException e) {
            throw new RuntimeException(e);
        }
        LOGGER.debug("");
        LOGGER.debug("Patients:");
        for (Patient item : hospital.getPatients()) {
            LOGGER.debug(item.toString());
        }

        // create departments and set to hospital
        Map<String, Department> departments = null;
        try {
            departments = new ToolDepartment().createDepartment();
        } catch (InvalidNameException e) {
            throw new RuntimeException(e);
        }
        hospital.setDepartments(departments);

        hospital.getDepartments().get("crd").setDoctor(cardiologists);
        hospital.getDepartments().get("dnt").setDoctor(dentists);
        hospital.getDepartments().get("emr").setDoctor(emergencys);
        hospital.getDepartments().get("inf").setDoctor(infectiologysts);
        hospital.getDepartments().get("sur").setDoctor(surgeons);

        Comparator<Doctor> priceComparator = new Comparator<Doctor>() {
            @Override
            public int compare(Doctor doc1, Doctor doc2) {
                return doc1.getPrice().compareTo(doc2.getPrice());
            }
        };

        // set doctors date free from today and sort price
        LOGGER.debug("");
        LOGGER.debug("doctors:");
        for (Map.Entry<String, Department> entry : hospital.getDepartments().entrySet()) {
            Department department = entry.getValue();
            Collections.sort(department.getDoctor(), priceComparator);
            List<Doctor> doctors = department.getDoctor();
            LOGGER.debug(department);
            for (Doctor doctor : doctors) {
                doctor.setFreeFromDate(LocalDate.now());
                LOGGER.debug("  " + doctor + " free from: " + doctor.getFreeFromDate());
            }
        }

        // match patients and doctors
        HospitalUtils.match(hospital.getDepartments(), hospital.getPatients());
        HospitalUtils.matchResultPatients(hospital);
        HospitalUtils.matchResultDoctors(hospital);
    }
}