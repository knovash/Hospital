package com.solvd.hospital.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hospital.exception.InvalidNameException;
import com.solvd.hospital.human.doctor.Dentist;
import com.solvd.hospital.human.doctor.Emergency;
import com.solvd.hospital.human.doctor.Surgeon;
import com.solvd.hospital.human.patient.Patient;
import com.solvd.hospital.human.property.Address;
import com.solvd.hospital.human.property.Credit;
import com.solvd.hospital.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Test {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Test.class);

    public static void main(String[] args) {

        // test Generic
        LOGGER.info("");
        LOGGER.info("test Generic");

        Dentist dentist1;
        Emergency emergency1;
        Surgeon surgeon1;
        Patient pat;
        try {
            pat = new Patient(LocalDate.of(1999, 2, 13), "A_lex", new Address("Belarus", "Minsk", "Berezovaja", 16), new Phone("+375", "29", "883300"), new Credit("Prior", "BYN", new BigDecimal("500")));
            dentist1 = new Dentist("Olga", "Dentist", new BigDecimal("600"));
            emergency1 = new Emergency("Olga", "Emergency", new BigDecimal("600"));
            surgeon1 = new Surgeon("Olga", "Surgeon", new BigDecimal("600"));
        } catch (InvalidNameException e) {
            throw new RuntimeException(e);
        }

        CureTestGeneric<Dentist> cureDentist = new CureTestGeneric<Dentist>("den", dentist1, pat);
        CureTestGeneric<Emergency> cureEmergency = new CureTestGeneric<Emergency>("emr", emergency1, pat);
        CureTestGeneric<Surgeon> cureSurgeon = new CureTestGeneric<Surgeon>("sur", surgeon1, pat);

        cureDentist.getDoc().makeDentalFilling();
        cureEmergency.getDoc().makeFirstAid();
        cureSurgeon.getDoc().makeOperation();
    }
}
