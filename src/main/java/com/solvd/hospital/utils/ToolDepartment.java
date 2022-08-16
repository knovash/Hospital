package com.solvd.hospital.utils;

import com.solvd.hospital.exception.InvalidNameException;
import com.solvd.hospital.hospital.department.*;
import com.solvd.hospital.human.doctor.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ToolDepartment {

    public Map<String, Department> createDepartment() throws InvalidNameException {

        DepartmentCardiology<Cardiologist> depCar = new DepartmentCardiology("cardio");
        depCar.setDoctor(new ArrayList<Cardiologist>());
        DepartmentDental<Dentist> depDen = new DepartmentDental("dental");
        depDen.setDoctor(new ArrayList<Dentist>());
        DepartmentEmergency<Emergency> depEmr = new DepartmentEmergency("emergency");
        depEmr.setDoctor(new ArrayList<Emergency>());
        DepartmentInfectious<Infectiologist> depInf = new DepartmentInfectious("infect");
        depInf.setDoctor(new ArrayList<Infectiologist>());
        DepartmentSurgery<Surgeon> depSur = new DepartmentSurgery("surgery");
        depSur.setDoctor(new ArrayList<Surgeon>());

        Map<String, Department> departments = new HashMap<>();

        departments.put("crd", depCar);
        departments.put("dnt", depDen);
        departments.put("emr", depEmr);
        departments.put("inf", depInf);
        departments.put("sur", depSur);

        return departments;
    }
}