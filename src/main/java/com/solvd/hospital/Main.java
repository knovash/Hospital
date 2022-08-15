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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static javax.print.attribute.standard.MediaSizeName.D;

public class Main {

//    static {
//        System.setProperty("log4j.configurationFile", "log4j2.xml");
//    }

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

        Surgeon sur1 = new Surgeon("dd","dd",new BigDecimal(99));
        List<Surgeon> surs = new ArrayList<>();
        surs.add(sur1);

        Dentist den1 = new Dentist("dd","dd",new BigDecimal(99));
        List<Dentist> dens = new ArrayList<>();
        dens.add(den1);

        DepartmentCardiology<Cardiologist> depCar = new DepartmentCardiology<Cardiologist>("car");
        DepartmentDental<Dentist> depDen = new DepartmentDental<Dentist>("den");
        DepartmentEmergency<Emergency> depEmr = new DepartmentEmergency<Emergency>("emr");
        DepartmentInfectious<Infectiologist> depInf = new DepartmentInfectious<Infectiologist>("inf");
        DepartmentSurgery<Surgeon> depSur = new DepartmentSurgery<Surgeon>("sur");


        depSur.setDoctor(surgeons);
        depDen.setDoctor(dens);
        depDen.getDoctor().get(0).makeDentalFilling();

        Map<String , Department> departments = new HashMap<>();
        departments.put("crd", depCar);
        departments.put("dnt", depDen);
        departments.put("emr", depEmr);
        departments.put("inf", depInf);
        departments.put("sur", depSur);




//        Map<String,Department> departments = new HashMap<>();
//        departments.put("crd", new DepartmentCardiology<Cardiologist>("Cardiology"));
//        departments.put("dnt", new DepartmentDental<Dentist>("Dental"));
//        departments.put("emr", new DepartmentEmergency<Emergency>("Emergency"));
//        departments.put("inf", new DepartmentInfectious<Infectiologist>("Infectious"));
//        departments.put("sur", new DepartmentSurgery<Surgeon>("Surgery"));






        // create departments and set to hospital
//        Map<String, Department> departments;
//        try {
//            departments = new ToolDepartment().createDepartment();
//        } catch (InvalidNameException e) {
//            throw new RuntimeException(e);
//        }
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