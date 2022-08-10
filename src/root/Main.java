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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    static final Logger LOGGER = LogManager.getLogger(Main.class);

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
        Cardiologist[] cardiologists;
        Dentist[] dentists;
        Emergency[] emergencys;
        Infectiologist[] infectiologysts;
        Surgeon[] surgeons;
        try {
            cardiologists = new ToolDoctor().createCardiologist();
            dentists = new ToolDoctor().createDentist();
            emergencys = new ToolDoctor().createEmergency();
            infectiologysts = new ToolDoctor().createInfectioligist();
            surgeons = new ToolDoctor().createSurgeon();
        } catch (InvalidNameException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }

        List<Cardiologist> cardList =new ArrayList<>();
        List<Dentist> dentList =new ArrayList<>();
        List<Emergency> emerList =new ArrayList<>();
        List<Infectiologist> infList =new ArrayList<>();
        List<Surgeon> surList =new ArrayList<>();

        Collections.addAll(cardList, cardiologists);
        Collections.addAll(dentList, dentists);
        Collections.addAll(emerList, emergencys);
        Collections.addAll(infList, infectiologysts);
        Collections.addAll(surList, surgeons);

        List<Department> depsList = new ArrayList<>();

        DepartmentCardiology depCard = new DepartmentCardiology("Cardiology");
        DepartmentDental depDent = new DepartmentDental("Dental");
        Department depEmr = new DepartmentEmergency("Emergency");
        DepartmentInfectious depInf = new DepartmentInfectious("Infectious");
        DepartmentSurgery depSur = new DepartmentSurgery("Surgery");

        depsList.add(depCard);
        depsList.add(depDent);
        depsList.add(depEmr);
        depsList.add(depInf);
        depsList.add(depSur);

        depsList.get(0).setDoctor(dentList);



        // create departments
        Department[] departments = new ToolDepartment().create();
        // set doctors to departments
//        departments[0].setDoctor(cardiologists);
//        departments[1].setDoctor(dentists);
//        departments[2].setDoctor(emergencys);
//        departments[3].setDoctor(infectiologysts);
//        departments[4].setDoctor(surgeons);
        // set departments to hospital
        hospital.setDepartments(depsList);
        // set doctors date free from now
        LOGGER.info("");
        LOGGER.info("doctors:");
        for (Department department : hospital.getDepartments()) {
            LOGGER.info(department.toString());
            for (Doctor doctor : department.getDoctor()) {
                doctor.setFreeFromDate(LocalDate.now());
                LOGGER.info("  " + doctor);
            }
        }

        // create patients
        LOGGER.debug("try create patients");
        Patient[] patients = new Patient[0];
        try {
            patients = new ToolPatient().create();
        } catch (InvalidNameException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }  finally {
            LOGGER.debug("try create Patients end");
        }
        // set patients to hospital
        try {
            hospital.setPatients(patients);
        } catch (ArrayOneElementException e) {
            LOGGER.warn(e.getMessage(), e);
        } finally {
            LOGGER.debug("set patients to hospital. end.");
        }

        LOGGER.info("patients:");
        for (Patient patient : hospital.getPatients()) {
            LOGGER.info(patient.toString());
        }

        // match patients and doctors
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

        // test try with resources
        try (Resource resource = new Resource()) {
            LOGGER.info("resource close");
        }
    }

    public static class Resource implements AutoCloseable {

        private String name;

        @Override
        public void close() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}