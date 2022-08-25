package com.solvd.hospital.utils;

import com.solvd.hospital.human.doctor.Doctor;
@FunctionalInterface
public interface Searchable {
    boolean search(Doctor doctor);
}