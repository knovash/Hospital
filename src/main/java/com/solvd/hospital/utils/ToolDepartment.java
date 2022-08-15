package com.solvd.hospital.utils;

import com.solvd.hospital.exception.InvalidNameException;
import com.solvd.hospital.hospital.department.*;
import com.solvd.hospital.human.doctor.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ToolDepartment {

    public Map<String, Department> createDepartment() throws InvalidNameException {

        DepartmentCardiology<Cardiologist> depCar = new DepartmentCardiology<Cardiologist>("cardio");
        depCar.setDoctor(new ArrayList<Cardiologist>());
        DepartmentDental<Dentist> depDen = new DepartmentDental<Dentist>("dental");
        depDen.setDoctor(new ArrayList<Dentist>());
        DepartmentEmergency<Emergency> depEmr = new DepartmentEmergency<Emergency>("emergency");
        depEmr.setDoctor(new ArrayList<Emergency>());
        DepartmentInfectious<Infectiologist> depInf = new DepartmentInfectious<Infectiologist>("infect");
        depInf.setDoctor(new ArrayList<Infectiologist>());
        DepartmentSurgery<Surgeon> depSur = new DepartmentSurgery<Surgeon>("surgery");
        depSur.setDoctor(new ArrayList<Surgeon>());

        Map<String,Department> departments = new HashMap<>();

        departments.put("crd", depCar);
        departments.put("dnt", depDen);
        departments.put("emr", depEmr);
        departments.put("inf", depInf);
        departments.put("sur", depSur);

//        departments.put("crd", new DepartmentCardiology<Cardiologist>("Cardiology"));
//        departments.put("dnt", new DepartmentDental<Dentist>("Dental"));
//        departments.put("emr", new DepartmentEmergency<Emergency>("Emergency"));
//        departments.put("inf", new DepartmentInfectious<Infectiologist>("Infectious"));
//        departments.put("sur", new DepartmentSurgery<Surgeon>("Surgery"));

        return departments;
    }
}