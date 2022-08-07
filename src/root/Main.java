package root;

import root.hospital.Hospital;
import root.utils.HospitalUtils;
import root.hospital.department.Department;
import root.human.properties.Phone;
import root.utils.TestPolymorph;
import root.human.doctor.*;
import root.human.patient.Patient;
import root.human.patient.prescription.medicine.Injection;
import root.human.patient.prescription.medicine.Medicine;
import root.human.patient.prescription.medicine.Pill;
import root.utils.ToolDepartment;
import root.utils.ToolDoctor;
import root.utils.ToolHospital;
import root.utils.ToolPatient;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // test polymorphysm

       Injection insulin = new Injection("insulin", "shugar", 10,100);
       Pill aspirin = new Pill("aspirin", "head", 20,200);
       Medicine calcium = new Medicine("aspirin", "head", 20,200);
       Medicine iod = new Pill("aspirin", "head", 20,200);
       insulin.takeInjection();
       insulin.takeMedicine();
       aspirin.takePill();
       aspirin.takeMedicine();
       calcium.takeMedicine();
       iod.takeMedicine();


        // create hospital
        Hospital hospital = ToolHospital.create();
        // print hospital. test ToString override
        System.out.println("Create hospital:");
        System.out.println(hospital);
        System.out.println(hospital.getAddress().toString());
        for (Phone item : hospital.getPhones()) {
            System.out.println(item.toString());
        }

        // create empty departments (without doctors)
        Department[] departments = new ToolDepartment().create();
        hospital.setDepartments(departments);

        // print hospital departments names
        System.out.println();
        System.out.println("get names from departments[] from hospital");
        for (Department item : hospital.getDepartments()
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
        HospitalUtils.print(dentists);    // overload
        HospitalUtils.print(emergencys);    // overload

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
        hospital.setPatients(patients);
        System.out.println("hospital.getPatients:");
        //HospitalUtils.print(hospital.getPatients());   // owerload


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
