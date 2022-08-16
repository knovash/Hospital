package com.solvd.hospital;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.solvd.hospital.exception.*;
import com.solvd.hospital.hospital.Hospital;
import com.solvd.hospital.hospital.department.*;
import com.solvd.hospital.human.property.Phone;
import com.solvd.hospital.human.doctor.*;
import com.solvd.hospital.human.patient.Patient;
import com.solvd.hospital.utils.*;

import java.time.LocalDate;
import java.util.*;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InvalidNameException {
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
        List<Cardiologist> cardiologists;
        List<Dentist> dentists;
        List<Emergency> emergencys;
        List<Infectiologist> infectiologysts;
        List<Surgeon> surgeons;
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

        // TRY create List departments

//
        List<Department> deps = new ArrayList<>();
//
        DepartmentCardiology<Cardiologist> depCar = new DepartmentCardiology<>("card");
        DepartmentDental<Dentist> depDen = new DepartmentDental<>("dent");
        DepartmentEmergency<Emergency> depEmr = new DepartmentEmergency<>("emrg");
//
        depCar.setDoctor(cardiologists);
        depDen.setDoctor(dentists);
        depEmr.setDoctor(emergencys);
//        depEmr.setDoctor(dentists); //test
//
        deps.add(depCar);
        deps.add(depDen);
        deps.add(depEmr);

        deps.get(0).getDoctor().get(0).toString();


        // create Map departments and set to hospital
        Map<String, Department> departments;

        try {
            departments = new ToolDepartment().createDepartment();
        } catch (InvalidNameException e) {
            throw new RuntimeException(e);
        }
        hospital.setDepartments(departments);

        hospital.getDepartments().get("crd").setDoctor(cardiologists);
        hospital.getDepartments().get("dnt").setDoctor(emergencys);
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