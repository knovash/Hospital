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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        // create hospital
        Hospital hospital = ToolHospital.create();
        LOGGER.info("Create hospital:");
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
        LOGGER.info("");
        LOGGER.info("Patients:");
        for (Patient item : hospital.getPatients()) {
            LOGGER.info(item.toString());
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
        LOGGER.info("");
        LOGGER.info("doctors:");
        for (Map.Entry<String, Department> entry : hospital.getDepartments().entrySet()) {
            Department department = entry.getValue();
            Collections.sort(department.getDoctor(), priceComparator);
            LOGGER.info(department);
            for (Doctor doctor : department.getDoctor()) {
                doctor.setFreeFromDate(LocalDate.now());
                LOGGER.info("  " + doctor + " free from: " + doctor.getFreeFromDate());
            }
        }

        // match patients and doctors
        HospitalUtils.match(hospital.getDepartments(), hospital.getPatients());
        HospitalUtils.matchResultPatients(hospital);
        HospitalUtils.matchResultDoctors(hospital);

        // test Generic
        LOGGER.info("");
        LOGGER.info("test Generic");

        Dentist dentist1 = null;
        Emergency emergency1 = null;
        Surgeon surgeon1 = null;
        try {
            dentist1 = new Dentist("Olga", "Dentist", new BigDecimal("600"));
            emergency1 = new Emergency("Olga", "Emergency", new BigDecimal("600"));
            surgeon1 = new Surgeon("Olga", "Surgeon", new BigDecimal("600"));
        } catch (InvalidNameException e) {
            throw new RuntimeException(e);
        }

        Doctor doc1 = hospital.getDepartments().get("dnt").getDoctor().get(0);
        CurePatient<Dentist> cureDentist = new CurePatient<Dentist>("den", dentist1, patients.get(0));
        CurePatient<Emergency> cureEmergency = new CurePatient<Emergency>("emr", emergency1, patients.get(0));
        CurePatient<Surgeon> cureSurgeon = new CurePatient<Surgeon>("sur", surgeon1, patients.get(0));

        cureDentist.getDoc().doPullOutTooth();
        cureEmergency.getDoc().doFirstAid();
        cureSurgeon.getDoc().doOperation();

    }
}