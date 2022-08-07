package root;

import root.hospital.Hospital;
import root.hospital.HospitalUtils;
import root.hospital.department.Department;
import root.human.Phone;
import root.human.TestPolymorph;
import root.human.doctor.*;
import root.human.patient.Patient;
import root.tool.ToolDepartment;
import root.tool.ToolDoctor;
import root.tool.ToolHospital;
import root.tool.ToolPatient;

import java.time.LocalDate;

import static root.human.TestPolymorph.printName;

public class Main {
    public static void main(String[] args) {

        // create hospital
        Hospital hospital = ToolHospital.create();
        // print hospital
        System.out.println("Create hospital:");
        System.out.println(hospital.getName() + " founded at " + hospital.getDateOfFoundation());
        System.out.println(hospital.getAddress().getCountry() + " " + hospital.getAddress().getCity());
        for (Phone item : hospital.getPhone()) {
            System.out.println(item.getCountryCode() + item.getCityCode() + item.getLocalNumber());
        }

        // test toString override. print hospital
        System.out.println("to string " + hospital.toString());

        // create empty departments (without doctors)
        Department[] departments = new ToolDepartment().create();
        hospital.setDepartment(departments);

        // print hospital departments names
        System.out.println();
        System.out.println("get names from dep[] from hospital");
        for (Department item : hospital.getDepartment()
        ) {
            System.out.println(item.getName());
        }

        // create doctors arrays
        Cardiologist[] cardiologists = new ToolDoctor().createCardiologist();
        Dentist[] dentists = new ToolDoctor().createDentist();
        Emergency[] emergencys = new ToolDoctor().createEmergency();
        Infectiologist[] infectiologists = new ToolDoctor().createInfectioligist();
        Surgeon[] surgeons = new ToolDoctor().createSurgeon();

        // test override method
        surgeons[1].doOperation();
        surgeons[1].makeDiagnosis();
        surgeons[1].makePrescription();

        emergencys[1].makeDiagnosis();
        emergencys[1].doFirstAid();
        emergencys[1].makePrescription();



        System.out.println();
        System.out.println("Doctors:");
        HospitalUtils.print(dentists);    // owerload
        HospitalUtils.print(emergencys);    // owerload

        departments[0].setDoctor(cardiologists);
        departments[1].setDoctor(dentists);
        departments[2].setDoctor(emergencys);
        departments[3].setDoctor(infectiologists);
        departments[4].setDoctor(surgeons);

        // print doctors names from all departments
//        for (Department dep:hospital.getDepartment()             ) {
//            System.out.println("Department name: " + dep.getName());
//            for(Doctor doc:dep.getDoctor()){
//                System.out.println("Doctor name: " + doc.getName() + " " + doc.getSpecialty());
//            }
//        }



        System.out.println("Total Doctors in hospital: " + Doctor.countDoctor);
        System.out.println("Total Cardiologists in hospital: " + Cardiologist.countCardiologist);
        System.out.println("Total Dentist in hospital: " + Dentist.countDentist);
        System.out.println("Total Emergency in hospital: " + Emergency.countEmergency);
        System.out.println("Total Infectiologist in hospital: " + Infectiologist.countInectiologist);
        System.out.println("Total Surgeon in hospital: " + Surgeon.countSurgeon);


        // create patients
        System.out.println();
        System.out.println("Patients:");
        Patient[] patients = new ToolPatient().create();
        hospital.setPatient(patients);
        System.out.println("hospital.getPatients:");
        HospitalUtils.print(hospital.getPatient());   // owerload


        System.out.println();
        System.out.println("Test polymorph Department :");
        TestPolymorph.printName(departments[0]);
        TestPolymorph.printName(departments[1]);
        TestPolymorph.printName(departments[2]);

        // set all doctors free from now
        for (Doctor item : cardiologists
        ) {
            item.setDateFreeFrom(LocalDate.now());
        }
        for (Doctor item : dentists
        ) {
            item.setDateFreeFrom(LocalDate.now());
        }
        for (Doctor item : emergencys
        ) {
            item.setDateFreeFrom(LocalDate.now());
        }
        for (Doctor item : infectiologists
        ) {
            item.setDateFreeFrom(LocalDate.now());
        }
        for (Doctor item : surgeons
        ) {
            item.setDateFreeFrom(LocalDate.now());
        }

        System.out.println();
        System.out.println("matching patients and doctors...");
        System.out.println();

        HospitalUtils.match(cardiologists, patients);
        HospitalUtils.match(dentists, patients);
        HospitalUtils.match(emergencys, patients);
        HospitalUtils.match(infectiologists, patients);
        HospitalUtils.match(surgeons, patients);

        System.out.println();
        System.out.println("match result:");
        HospitalUtils.matchResult(patients);





    }
}
