package root.utils;

import root.human.properties.Address;
import root.human.properties.Credit;
import root.hospital.Hospital;
import root.human.properties.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ToolHospital {

    public static Hospital create() {
        Address hospitalAddress = new Address("Belarus", "Minsk", "Pushkina", 66);
        Phone hospitalPhoneCity = new Phone("+375", "17", "33-44-55");
        Phone hospitalPhoneA1 = new Phone("+375", "29", "33-44-55");
        Phone hospitalPhoneMts = new Phone("+375", "44", "33-44-55");
        Phone[] hospitalPhones = {hospitalPhoneCity, hospitalPhoneA1, hospitalPhoneMts};
        Credit hospitalCreditByn = new Credit("PriorBank", "USD", new BigDecimal("5000000"));
        Credit hospitalCreditRub = new Credit("PriorBank", "BYN", new BigDecimal("1000000"));
        Credit[] hospitalCredits = {hospitalCreditByn, hospitalCreditRub};
        LocalDate dateOfFoundation = LocalDate.of(1888, 10, 3);
        Hospital hospital = new Hospital("Arkham", dateOfFoundation, hospitalAddress, hospitalPhones, hospitalCredits);
        return hospital;
    }
}