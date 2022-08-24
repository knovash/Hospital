package com.solvd.hospital.human.doctor;

import com.solvd.hospital.utils.Searchable;

import java.math.BigDecimal;

public class LuxDoctor implements Searchable {

    @Override
    public boolean search(Doctor doctor) {
        return doctor.getPrice().compareTo(new BigDecimal(500)) == 1;
    }
}