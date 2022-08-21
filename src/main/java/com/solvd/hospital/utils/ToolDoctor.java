package com.solvd.hospital.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.solvd.hospital.exception.InvalidNameException;
import com.solvd.hospital.human.Human;
import com.solvd.hospital.human.doctor.*;

public class ToolDoctor {

    public List<Cardiologist> createCardiologist() throws InvalidNameException {
        List<Cardiologist> list = new ArrayList<>();
        list.add(new Cardiologist("Ivan", "Cardiologist", Spec.CARD, new BigDecimal("700")));
        list.get(list.size()-1).setGender(Human.Gender.MALE);
        list.add(new Cardiologist("Sergey", "Cardiologist", Spec.CARD, new BigDecimal("600")));
        list.get(list.size()-1).setGender(Human.Gender.MALE);
        list.add(new Cardiologist("Nikolay", "Cardiologist", Spec.CARD, new BigDecimal("800")));
        list.get(list.size()-1).setGender(Human.Gender.MALE);
        return list;
    }

    public List<Dentist> createDentist() throws InvalidNameException {
        List<Dentist> list = new ArrayList<>();
        list.add(new Dentist("Igor", "Dentist", Spec.DENT, new BigDecimal("1500")));
        list.get(list.size()-1).setGender(Human.Gender.MALE);
        list.add(new Dentist("Olga", "Dentist", Spec.DENT, new BigDecimal("700")));
        list.get(list.size()-1).setGender(Human.Gender.FEMALE);
        list.add(new Dentist("Anna", "Dentist", Spec.DENT, new BigDecimal("300")));
        list.get(list.size()-1).setGender(Human.Gender.FEMALE);
        list.add(new Dentist("Dima", "Dentist", Spec.DENT, new BigDecimal("200")));
        list.get(list.size()-1).setGender(Human.Gender.MALE);
        list.add(new Dentist("Egor", "Dentist", Spec.DENT, new BigDecimal("1200")));
        list.get(list.size()-1).setGender(Human.Gender.MALE);
        return list;
    }

    public List<Emergency> createEmergency() throws InvalidNameException {
        List<Emergency> list = new ArrayList<>();
        list.add(new Emergency("Irina", "Emergency", Spec.EMER, new BigDecimal("200")));
        list.get(list.size()-1).setGender(Human.Gender.FEMALE);
        list.add(new Emergency("Victor", "Emergency", Spec.EMER, new BigDecimal("100")));
        list.get(list.size()-1).setGender(Human.Gender.MALE);
        return list;
    }

    public List<Infectiologist> createInfectiologist() throws InvalidNameException {
        List<Infectiologist> list = new ArrayList<>();
        list.add(new Infectiologist("Zina", "Infectiologist", Spec.INFECT, new BigDecimal("400")));
        list.get(list.size()-1).setGender(Human.Gender.FEMALE);
        list.add(new Infectiologist("Lena", "Infectiologist", Spec.INFECT, new BigDecimal("300")));
        list.get(list.size()-1).setGender(Human.Gender.FEMALE);
        return list;
    }

    public List<Surgeon> createSurgeon() throws InvalidNameException {
        List<Surgeon> list = new ArrayList<>();
        list.add(new Surgeon("Oleg", "Surgeon", Spec.SURG, new BigDecimal("1500")));
        list.get(list.size()-1).setGender(Human.Gender.MALE);
        list.add(new Surgeon("Julia", "Surgeon", Spec.SURG, new BigDecimal("1000")));
        list.get(list.size()-1).setGender(Human.Gender.FEMALE);
        return list;
    }
}