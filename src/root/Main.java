package root;

import root.hospital.Hospital;
import root.hospital.department.*;
import root.human.properties.Address;
import root.utils.HospitalUtils;
import root.human.properties.Phone;
import root.human.doctor.*;
import root.human.patient.Patient;
import root.utils.ToolDoctor;
import root.utils.ToolHospital;
import root.utils.ToolPatient;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // create hospital
        Hospital hospital = ToolHospital.create();
        System.out.println("Create hospital:");
        System.out.println(hospital);
        System.out.println(hospital.getAddress().toString());
        for (Phone item : hospital.getPhones()) {
            System.out.println(item.toString());
        }
        // create doctors
        Cardiologist[] cardiologists = new ToolDoctor().createCardiologist();
        Dentist[] dentists = new ToolDoctor().createDentist();
        Emergency[] emergencys = new ToolDoctor().createEmergency();
        Infectiologist[] infectiologysts = new ToolDoctor().createInfectioligist();
        Surgeon[] surgeons = new ToolDoctor().createSurgeon();
        // create departments
        Department[] departments = new Department[5];
        departments[0] = new DepartmentCardiology("Cardiology");
        departments[1] = new DepartmentDental("Dental");
        departments[2] = new DepartmentEmergency("Emergency");
        departments[3] = new DepartmentInfectious("Infectious");
        departments[4] = new DepartmentSurgery("Surgery");
        // set doctors to departments
        departments[0].setDoctor(cardiologists);
        departments[1].setDoctor(dentists);
        departments[2].setDoctor(emergencys);
        departments[3].setDoctor(infectiologysts);
        departments[4].setDoctor(surgeons);
        // set departments to hospital
        hospital.setDepartments(departments);
        // set doctors date free from now
        System.out.println();
        System.out.println("doctors:");
        for (Department department : hospital.getDepartments()) {
            System.out.println(department.toString());
            Doctor[] docs = department.getDoctor();
            for (Doctor doctor : department.getDoctor()) {
                doctor.setDateFreeFrom(LocalDate.now());
                System.out.println("  " + doctor.toString());
            }
        }
        // create patients
        Patient[] patients = new ToolPatient().create();
        hospital.setPatients(patients);
        System.out.println();
        System.out.println("patients:");
        for (Patient patient : hospital.getPatients()) {
            System.out.println(patient.toString());
        }

        // some tests
        System.out.println("some tests:");

        Address adr1 = new Address("ccc", "city", "street", 11);
        Address adr2 = new Address("ccc", "city", "street", 11);

        System.out.println(adr1.toString());
        System.out.println(adr2.toString());
        System.out.println(adr1 == adr2);
        System.out.println("adr1 eq adr2 " + adr1.equals(adr2));

//        System.out.println();
//        Department dep1 = hospital.getDepartments()[0];
//        Doctor doc1 = dep1.getDoctor()[0];
//        Doctor doc2 = dep1.getDoctor()[1];
//        System.out.println(doc1.toString());
//        System.out.println(doc2.toString());
//        System.out.println(doc1 == doc2);
//        System.out.println("doc1 eq doc2 " + doc1.equals(doc2));

        System.out.println();
        Patient pat1 = hospital.getPatients()[0];
        Patient pat2 = hospital.getPatients()[1];
        Patient pat3 = hospital.getPatients()[2];
        System.out.println(pat1.toString());
        System.out.println(pat2.toString());
        System.out.println(pat3.toString());
        System.out.println();
        System.out.println("pat1 eq pat2 " + pat1.equals(pat2));
        System.out.println();
        System.out.println("pat1 eq pat3 " + pat1.equals(pat3));






        // matchint patients and doctors
//        System.out.println();
//        System.out.println("matching patients and doctors...");
//        System.out.println();
//        for (Department department : hospital.getDepartments()) {
//            System.out.println(department.toString());
//            HospitalUtils.match(department.getDoctor(), hospital.getPatients());
//        }
//        System.out.println();
//        System.out.println("match result:");
//        HospitalUtils.matchResult(hospital.getPatients());
    }
}