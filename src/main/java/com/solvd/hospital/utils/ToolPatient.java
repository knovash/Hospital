package com.solvd.hospital.utils;

import com.solvd.hospital.exception.InvalidNameException;
import com.solvd.hospital.human.Human;
import com.solvd.hospital.human.doctor.Spec;
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

        list.add(new Patient(LocalDate.of(1988, 2, 13), "Igor", Human.Gender.MALE, new Address("Belarus", "Minsk", "Berezovaja", 16), new Phone("+375", "29", "883300"), new Credit("Prior", "BYN", new BigDecimal("3000"))));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Dentist", Spec.DENT));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Emergency", Spec.EMER));

        list.add(new Patient(LocalDate.of(1999, 2, 13), "A_lex", Human.Gender.MALE, new Address("Belarus", "Minsk", "Berezovaja", 16), new Phone("+375", "29", "883300"), new Credit("Prior", "BYN", new BigDecimal("500"))));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Dentist", Spec.DENT));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Emergency", Spec.EMER));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Surgeon", Spec.SURG));

        list.add(new Patient(LocalDate.of(1999, 2, 13), "Vera", Human.Gender.FEMALE, new Address("Belarus", "Minsk", "Berezovaja", 16), new Phone("+375", "29", "883300"), new Credit("Prior", "BYN", new BigDecimal("3000"))));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Cardiologist", Spec.CARD));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Dentist", Spec.DENT));

        list.add(new Patient(LocalDate.of(1999, 2, 13), "Olga", Human.Gender.FEMALE, new Address("Belarus", "Minsk", "Berezovaja", 16), new Phone("+375", "29", "883300"), new Credit("Prior", "BYN", new BigDecimal("800"))));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Infectiologist", Spec.INFECT));

        list.add(new Patient(LocalDate.of(1965, 2, 13), "Victor", Human.Gender.MALE, new Address("Belarus", "Minsk", "Berezovaja", 16), new Phone("+375", "29", "883300"), new Credit("Prior", "BYN", new BigDecimal("800"))));
        list.get(list.size()-1).addTrouble(new Trouble(LocalDate.now(), "Dentist", Spec.DENT));

        return list;
    }
}