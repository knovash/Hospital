package com.solvd.hospital.hospital.department;

import com.solvd.hospital.human.doctor.Infectiologist;

public class DepartmentInfectious extends Department<Infectiologist> {

    public DepartmentInfectious(String name, Dep dep) {
        super(name, dep);
    }
}