package root.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import root.exception.InvalidNameException;
import root.human.doctor.*;

public class ToolDoctor {

    public List<Doctor> createCardiologist() throws InvalidNameException {
        List<Doctor> list = new ArrayList<>();
        list.add(new Cardiologist("Alex", "Cardiologist", new BigDecimal("500")));
        list.add(new Cardiologist("Denis", "Cardiologist", new BigDecimal("300")));
        return list;
    }

    public List<Doctor> createDentist() throws InvalidNameException {
        List<Doctor> list = new ArrayList<>();
        list.add(new Dentist("Igor", "Dentist", new BigDecimal("700")));
        list.add(new Dentist("Olga", "Dentist", new BigDecimal("600")));
        list.add(new Dentist("Vova", "Dentist", new BigDecimal("800")));
        return list;
    }

    public List<Doctor> createEmergency() throws InvalidNameException {
        List<Doctor> list = new ArrayList<>();
        list.add(new Emergency("Irina", "Emergency", new BigDecimal("200")));
        list.add(new Emergency("Victor", "Emergency", new BigDecimal("100")));
        return list;
    }

    public List<Doctor> createInfectiologist() throws InvalidNameException {
        List<Doctor> list = new ArrayList<>();
        list.add(new Infectiologist("Zina", "Infectiologist", new BigDecimal("400")));
        list.add(new Infectiologist("Lena", "Infectiologist", new BigDecimal("300")));
        return list;
    }

    public List<Doctor> createSurgeon() throws InvalidNameException {
        List<Doctor> list = new ArrayList<>();
        list.add(new Surgeon("Oleg", "Surgeon", new BigDecimal("1500")));
        list.add(new Surgeon("Petr", "Surgeon", new BigDecimal("1000")));
        return list;
    }
}