package com.solvd.hospital.hospital.department;

import com.solvd.hospital.human.doctor.Emergency;

public class DepartmentEmergency extends Department<Emergency> {

    public DepartmentEmergency(String name, Dep dep) {
        super(name, dep);
    }
}