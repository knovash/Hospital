package com.solvd.hospital;

import com.solvd.hospital.human.doctor.function.Searchable;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.solvd.hospital.exception.*;
import com.solvd.hospital.hospital.Hospital;
import com.solvd.hospital.hospital.department.*;
import com.solvd.hospital.human.doctor.*;
import com.solvd.hospital.human.patient.Patient;
import com.solvd.hospital.utils.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
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
        hospital.getPhones().forEach(phone -> LOGGER.info(phone.toString()));

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
        patients = new ToolPatient().createPatient();
        try {
            hospital.setPatients(patients);
        } catch (ArrayOneElementException e) {
            throw new RuntimeException(e);
        }

        LOGGER.debug("");
        LOGGER.debug("P A T I E N T S:");
        hospital.getPatients().forEach(patient -> LOGGER.debug(patient.toString()));

        DepartmentCardiology depCardiology = new DepartmentCardiology("Department Cardiology", Dep.CARD);
        DepartmentDental depDental = new DepartmentDental("Department Dental", Dep.DENT);
        DepartmentEmergency depEmergency = new DepartmentEmergency("Department Emergency", Dep.EMER);
        DepartmentInfectious depInfectious = new DepartmentInfectious("Department Infectious", Dep.INFECT);
        DepartmentSurgery depSurgery = new DepartmentSurgery("Department Surgery", Dep.SURG);

        depCardiology.setDoctors(cardiologists);
        depDental.setDoctors(dentists);
        depEmergency.setDoctors(emergencys);
        depInfectious.setDoctors(infectiologysts);
        depSurgery.setDoctors(surgeons);

        Map<String, Department<? extends Doctor>> departments = new HashMap<>();
        departments.put("crd", depCardiology);
        departments.put("dnt", depDental);
        departments.put("emr", depEmergency);
        departments.put("inf", depInfectious);
        departments.put("sur", depSurgery);

        hospital.setDepartments(departments);
        Comparator<Doctor> priceComparator = new Comparator<Doctor>() {
            @Override
            public int compare(Doctor doc1, Doctor doc2) {
                return doc1.getPrice().compareTo(doc2.getPrice());
            }
        };

        // set doctors date free from today and sort price
        LOGGER.debug("");
        LOGGER.debug("D O C T O R S:");
        hospital.getDepartments().entrySet().forEach(entry -> {
            Department<? extends Doctor> department = entry.getValue();
            department.getDoctors().sort(priceComparator);
            List<? extends Doctor> doctors = department.getDoctors();
            LOGGER.debug(department);
            doctors.forEach(doctor -> {
                doctor.setFreeFromDate(LocalDate.now());
                LOGGER.debug("  " + doctor + " free from: " + doctor.getFreeFromDate());
            });
        });

        // match patients and doctors
        HospitalUtils.match(hospital.getDepartments(), hospital.getPatients());
        HospitalUtils.matchResultPatients(hospital);
        HospitalUtils.matchResultDoctors(hospital);

        // test
        System.out.println("getExpensiveDoctorsNames");
        System.out.println(HospitalUtils.getExpensiveDoctorsNames(hospital));
        System.out.println("getLuxDoctorsNames");
        System.out.println(HospitalUtils.getLuxDoctorsNames(hospital));
        System.out.println("getDoctorsNamesContains");
        System.out.println(HospitalUtils.getDoctorsNamesContains(hospital));

        System.out.println("getSearchDoctorsNames ExpDoctor");
        System.out.println(HospitalUtils.getSearchDoctorsNames(hospital, new ExpDoctor()));
        System.out.println("getSearchDoctorsNames LuxDoctor");
        System.out.println(HospitalUtils.getSearchDoctorsNames(hospital, new LuxDoctor()));


        System.out.println("Lambda hospital");
        System.out.println(HospitalUtils.getSearchDoctorsNames(hospital,
                (Doctor doctor) -> doctor.getPrice().compareTo(new BigDecimal(500)) == 1));

    }
}