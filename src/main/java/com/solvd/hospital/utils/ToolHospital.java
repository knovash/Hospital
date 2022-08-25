package com.solvd.hospital.utils;

import com.solvd.hospital.human.property.Address;
import com.solvd.hospital.human.property.Credit;
import com.solvd.hospital.hospital.Hospital;
import com.solvd.hospital.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToolHospital {

    public static Hospital create() {

        Address hospitalAddress = new Address("Belarus", "Minsk", "Pushkina", 66);
        Phone hospitalPhoneCity = new Phone("+375", "17", "33-44-55");
        Phone hospitalPhoneA1 = new Phone("+375", "29", "33-44-55");
        Phone hospitalPhoneMts = new Phone("+375", "44", "33-44-55");
        List<Phone> hospitalPhones = new ArrayList<>();
        hospitalPhones.add(hospitalPhoneCity);
        hospitalPhones.add(hospitalPhoneA1);
        hospitalPhones.add(hospitalPhoneMts);
        Credit hospitalCreditByn = new Credit("PriorBank", "USD", new BigDecimal("5000000"));
        Credit hospitalCreditRub = new Credit("PriorBank", "BYN", new BigDecimal("1000000"));
        List<Credit> hospitalCredits = new ArrayList<>();
        hospitalCredits.add(hospitalCreditByn);
        hospitalCredits.add(hospitalCreditRub);
        LocalDate dateOfFoundation = LocalDate.of(1888, 10, 3);
        Hospital hospital = new Hospital("Arkham", dateOfFoundation, hospitalAddress, hospitalPhones, hospitalCredits);
        return hospital;
    }
}