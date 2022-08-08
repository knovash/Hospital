package root.utils;

import java.math.BigDecimal;
import java.time.LocalDate;

import root.exception.InvalidNameException;
import root.human.property.Address;
import root.human.doctor.*;
import root.human.property.Phone;

public class ToolDoctor {

    public Cardiologist[] createCardiologist() throws InvalidNameException {
        Cardiologist[] array = new Cardiologist[2];
        Address docAddress = new Address("Belarus", "Minsk", "Pushkina", 66);
        Phone docPhone = new Phone("+375", "17", "33-44-55");
        array[0] = new Cardiologist(LocalDate.of(1965, 2, 13), "Anna",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Cardiologist", new BigDecimal("500"));
        array[1] = new Cardiologist(LocalDate.of(1965, 2, 13), "Anna",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Cardiologist", new BigDecimal("500"));
        return array;
    }

    public Dentist[] createDentist() throws InvalidNameException {
        Dentist[] array = new Dentist[2];
        Address docAddress = new Address("Belarus", "Minsk", "Pushkina", 66);
        Phone docPhone = new Phone("+375", "17", "33-44-55");
        array[0] = new Dentist(LocalDate.of(1965, 2, 13), "Denis",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Dentist", new BigDecimal("500"));
        array[1] = new Dentist(LocalDate.of(1965, 2, 13), "Diana",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Dentist", new BigDecimal("500"));
        return array;
    }

    public Emergency[] createEmergency()throws InvalidNameException {
        Emergency[] array = new Emergency[3];
        Address docAddress = new Address("Belarus", "Minsk", "Pushkina", 66);
        Phone docPhone = new Phone("+375", "17", "33-44-55");
        array[0] = new Emergency(LocalDate.of(1965, 2, 13), "Elena",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Emergency", new BigDecimal("1000"));
        array[1] = new Emergency(LocalDate.of(1965, 2, 13), "Egor",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Emergency", new BigDecimal("500"));
        array[2] = new Emergency(LocalDate.of(1965, 2, 13), "Evgeny",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Emergency", new BigDecimal("300"));
        return array;
    }

    public Infectiologist[] createInfectioligist() throws InvalidNameException {
        Infectiologist[] array = new Infectiologist[1];
        Address docAddress = new Address("Belarus", "Minsk", "Pushkina", 66);
        Phone docPhone = new Phone("+375", "17", "33-44-55");
        array[0] = new Infectiologist(LocalDate.of(1965, 2, 13), "Irina",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Infectiologist", new BigDecimal("500"));
        return array;
    }

    public Surgeon[] createSurgeon() throws InvalidNameException {
        Surgeon[] array = new Surgeon[2];
        Address docAddress = new Address("Belarus", "Minsk", "Pushkina", 66);
        Phone docPhone = new Phone("+375", "17", "33-44-55");
        array[0] = new Surgeon(LocalDate.of(1965, 2, 13), "Sergey",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Surgeon", new BigDecimal("700"));
        array[1] = new Surgeon(LocalDate.of(1965, 2, 13), "Sveta",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Surgeon", new BigDecimal("300"));
        return array;
    }
}