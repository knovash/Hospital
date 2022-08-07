package root;

import root.hospital.Hospital;
import root.hospital.department.*;
import root.human.property.Phone;
import root.human.doctor.*;
import root.human.patient.Patient;
import root.utils.*;

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
        System.out.println();
        System.out.println("doctors:");
        for (Department department : hospital.getDepartments()) {
            System.out.println(department.toString());
            for (Doctor doctor : department.getDoctor()) {
                doctor.setFreeFromDate(LocalDate.now());
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
        // match patients and doctors
        System.out.println();
        System.out.println("matching patients and doctors...");
        System.out.println();
        for (Department department : hospital.getDepartments()) {
            System.out.println(department.toString());
            HospitalUtils.match(department.getDoctor(), hospital.getPatients());
        }
        System.out.println();
        System.out.println("match result:");
        HospitalUtils.matchResult(hospital.getPatients());

        // test interface
        System.out.println("interface");
        Patient patient = hospital.getPatients()[0];
        Doctor[] docs = hospital.getDepartments()[1].getDoctor();
        patient.makeAppointment(docs);  // (Doctors[], Patient[0])

    }
}