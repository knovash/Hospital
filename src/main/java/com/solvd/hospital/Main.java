package com.solvd.hospital;

import com.solvd.hospital.firstpackage.MyClass;
import com.solvd.hospital.human.Human;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.solvd.hospital.exception.*;
import com.solvd.hospital.hospital.Hospital;
import com.solvd.hospital.hospital.department.*;
import com.solvd.hospital.human.doctor.*;
import com.solvd.hospital.human.patient.Patient;
import com.solvd.hospital.utils.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
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

        LOGGER.debug("\n P A T I E N T S:");
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

//        Comparator<Doctor> priceComparator = new Comparator<Doctor>() {
//            @Override
//            public int compare(Doctor doc1, Doctor doc2) {
//                return doc1.getPrice().compareTo(doc2.getPrice());
//            }
//        };

        // functional interface with lambda
        Comparator<Doctor> priceComparator = (Doctor d1, Doctor d2) -> {
            return d1.getPrice().compareTo(d2.getPrice());
        };

        // set doctors date free from today and sort price
        LOGGER.debug("\n D O C T O R S:");
        hospital.getDepartments().entrySet().stream()
                .peek(departmentEntry -> departmentEntry.getValue().getDoctors().sort(priceComparator))
                .peek(departmentEntry -> LOGGER.debug(departmentEntry.getValue().getName()))
                .flatMap(departmentEntry -> departmentEntry.getValue().getDoctors().stream())
                .forEach(doctor -> LOGGER.debug("  " + doctor + " free from: " + doctor.getFreeFromDate()));

        // match patients and doctors
        LOGGER.info("\nM A T C H");
        HospitalUtils.match(hospital.getDepartments(), hospital.getPatients());
        HospitalUtils.matchResultPatients(hospital);
        HospitalUtils.matchResultDoctors(hospital);

        // test
        LOGGER.info("getExpensiveDoctorsNames");
        LOGGER.info(HospitalUtils.getExpensiveDoctorsNames(hospital));
        LOGGER.info("getLuxDoctorsNames");
        LOGGER.info(HospitalUtils.getLuxDoctorsNames(hospital));

        LOGGER.info("getSearchDoctorsNames ExpDoctor");
        LOGGER.info(HospitalUtils.searchDoctors(hospital, new ExpDoctor()));
        LOGGER.info("getSearchDoctorsNames LuxDoctor");
        LOGGER.info(HospitalUtils.searchDoctors(hospital, new LuxDoctor()));

        LOGGER.info("Lambda hospital");
        LOGGER.info(HospitalUtils.searchDoctors(hospital,
                (Doctor doctor) -> doctor.getPrice().compareTo(new BigDecimal(500)) == 1));
        LOGGER.info(HospitalUtils.searchDoctors(hospital,
                (Doctor doctor) -> doctor.getPrice().compareTo(new BigDecimal(500)) == -1));

        LOGGER.info("Lambda hospital Optional");
        LOGGER.info(HospitalUtils.searchDoctorsOpt(hospital,
                (Doctor doctor) -> doctor.getPrice().compareTo(new BigDecimal(500)) == 1).isPresent());

        // test Anonymous Class print Patients Doctors filtered by gender
        IPrint printFemale = new IPrint() {
            @Override
            public void printPatients() {
                LOGGER.info("patients female");
                hospital.getPatients().stream()
                        .filter(patient -> patient.getGender().equals(Human.Gender.FEMALE))
                        .forEach(patient -> LOGGER.debug(patient.toString()));
            }

            public void printDoctors() {
                LOGGER.info("doctors female");
                hospital.getDepartments().entrySet().stream()
                        .flatMap(departmentEntry -> departmentEntry.getValue().getDoctors().stream())
                        .filter(doctor -> doctor.getGender().equals(Human.Gender.FEMALE))
                        .forEach(doctor -> LOGGER.debug(doctor.toString()));
            }
        };

        IPrint printMale = new IPrint() {
            @Override
            public void printPatients() {
                LOGGER.info("patients male");
                hospital.getPatients().stream()
                        .filter(patient -> patient.getGender().equals(Human.Gender.MALE))
                        .forEach(patient -> LOGGER.debug(patient.toString()));
            }

            public void printDoctors() {
                LOGGER.info("doctors male");
                hospital.getDepartments().entrySet().stream()
                        .flatMap(departmentEntry -> departmentEntry.getValue().getDoctors().stream())
                        .filter(doctor -> doctor.getGender().equals(Human.Gender.MALE))
                        .forEach(doctor -> LOGGER.debug(doctor.toString()));
            }
        };

        LOGGER.info("Test Anonymous Method 2");
        doPrint(printMale);
        doPrint(printFemale);
        printFemale.printDoctors();
        printMale.printDoctors();
        printMale.printPatients();

        // test Functional interface
        IFunctional makeFuntion = new IFunctional() {
            @Override
            public void function(String text) {
                LOGGER.info("Test Functional Method " + text);
            }
        };

        IFunctional makeFunctionLambda = (text) -> LOGGER.info("Test Functional Method Lambda " + text);
        doFunction(makeFunctionLambda);

        // test optional
        Optional<Patient> maybeOld = patients.stream()
                .filter(patient -> patient.getDateOfBirth().isBefore(LocalDate.of(1600, 1, 1)))
                .peek(patient -> LOGGER.info("OPTIONAL: " + patient.getDateOfBirth() + " " + patient))
                .findFirst();
//        maybeOld.orElseThrow(() -> new RuntimeException("no too old"));
        Patient oldPatient = maybeOld.orElse(patients.get(0));
        maybeOld.ifPresentOrElse(patient -> {
            LOGGER.info("old: " + patient);
        }, () -> {
            LOGGER.info("no old");
        });
        LOGGER.info("OLD PATIENT: " + oldPatient);

        // Reflexion
        // MyClass my = new MyClass("sss");
        try {
            Class<MyClass> newClass = (Class<MyClass>) Class.forName("firstpackage.MyClass");
            Constructor<MyClass> newConstructor = newClass.getDeclaredConstructor(String.class, int.class);
            MyClass sss = newConstructor.newInstance("ivan", 22);
            Method method = newClass.getDeclaredMethod("doSmth", String.class, int.class);
            method.invoke(sss, "ddd", 3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // method for test Anonymous Class
    private static void doPrint(IPrint print) {
        print.printPatients();
        print.printDoctors();
    }

    // method for test Functional interface
    private static void doFunction(IFunctional func) {
        LOGGER.info("function");
        func.function("some text");
    }
}