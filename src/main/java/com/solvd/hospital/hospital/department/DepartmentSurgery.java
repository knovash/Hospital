package com.solvd.hospital.hospital.department;

import com.solvd.hospital.human.doctor.Surgeon;

public class DepartmentSurgery extends Department<Surgeon> {

    public DepartmentSurgery(String name, Dep dep) {
        super(name, dep);
    }
}