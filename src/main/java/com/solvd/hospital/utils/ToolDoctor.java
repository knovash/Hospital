package com.solvd.hospital.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.solvd.hospital.exception.InvalidNameException;
import com.solvd.hospital.human.doctor.*;

public class ToolDoctor {

    public List<Cardiologist> createCardiologist() throws InvalidNameException {
        List<Cardiologist> list = new ArrayList<>();
        list.add(new Cardiologist("Alex", "Cardiologist", new BigDecimal("500")));
        list.add(new Cardiologist("Denis", "Cardiologist", new BigDecimal("300")));
        return list;
    }

    public List<Dentist> createDentist() throws InvalidNameException {
        List<Dentist> list = new ArrayList<>();
        list.add(new Dentist("Igor", "Dentist", new BigDecimal("700")));
        list.add(new Dentist("Olga", "Dentist", new BigDecimal("600")));
        list.add(new Dentist("Vova", "Dentist", new BigDecimal("800")));
        return list;
    }

    public List<Emergency> createEmergency() throws InvalidNameException {
        List<Emergency> list = new ArrayList<>();
        list.add(new Emergency("Irina", "Emergency", new BigDecimal("200")));
        list.add(new Emergency("Victor", "Emergency", new BigDecimal("100")));
        return list;
    }

    public List<Infectiologist> createInfectiologist() throws InvalidNameException {
        List<Infectiologist> list = new ArrayList<>();
        list.add(new Infectiologist("Zina", "Infectiologist", new BigDecimal("400")));
        list.add(new Infectiologist("Lena", "Infectiologist", new BigDecimal("300")));
        return list;
    }

    public List<Surgeon> createSurgeon() throws InvalidNameException {
        List<Surgeon> list = new ArrayList<>();
        list.add(new Surgeon("Oleg", "Surgeon", new BigDecimal("1500")));
        list.add(new Surgeon("Petr", "Surgeon", new BigDecimal("1000")));
        return list;
    }
}