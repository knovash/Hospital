package com.solvd.hospital.utils;

import com.solvd.hospital.exception.InvalidNameException;
import com.solvd.hospital.human.patient.Trouble;
import com.solvd.hospital.human.property.Address;
import com.solvd.hospital.human.property.Credit;
import com.solvd.hospital.human.patient.Patient;
import com.solvd.hospital.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToolPatient {

    public List<Patient> createPatient() throws InvalidNameException {
        List<Patient> list = new ArrayList<>();

        list.add(new Patient(LocalDate.of(1988, 2, 13), "Igor", new Address("Belarus", "Minsk", "Berezovaja", 16), new Phone("+375", "29", "883300"), new Credit("Prior", "BYN", new BigDecimal("3000"))));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Dentist"));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Emergency"));

        list.add(new Patient(LocalDate.of(1999, 2, 13), "A_lex", new Address("Belarus", "Minsk", "Berezovaja", 16), new Phone("+375", "29", "883300"), new Credit("Prior", "BYN", new BigDecimal("500"))));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Dentist"));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Emergency"));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Surgeon"));

        list.add(new Patient(LocalDate.of(1999, 2, 13), "Vera", new Address("Belarus", "Minsk", "Berezovaja", 16), new Phone("+375", "29", "883300"), new Credit("Prior", "BYN", new BigDecimal("3000"))));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Cardiologist"));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Dentist"));

        list.add(new Patient(LocalDate.of(1999, 2, 13), "Konstantin", new Address("Belarus", "Minsk", "Berezovaja", 16), new Phone("+375", "29", "883300"), new Credit("Prior", "BYN", new BigDecimal("800"))));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Infectiologist"));

        list.add(new Patient(LocalDate.of(1965, 2, 13), "Victor", new Address("Belarus", "Minsk", "Berezovaja", 16), new Phone("+375", "29", "883300"), new Credit("Prior", "BYN", new BigDecimal("800"))));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Dentist"));

        return list;
    }
}