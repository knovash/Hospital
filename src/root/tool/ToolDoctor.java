package root.tool;

import java.time.LocalDate;

import root.human.Address;
import root.human.doctor.*;
import root.human.Phone;

public class ToolDoctor {

    public Cardiologist[] createCardiologist() {
        Cardiologist[] array = new Cardiologist[2];
        Address docAddress = new Address("Belarus", "Minsk", "Pushkina", 66);
        Phone docPhone = new Phone("+375", "17", "33-44-55");
        array[0] = new Cardiologist(LocalDate.of(1965, 2, 13), "Alex",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Cardiologist", 500);
        array[1] = new Cardiologist(LocalDate.of(1965, 2, 13), "Anna",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Cardiologist", 500);
        return array;
    }

    public Dentist[] createDentist() {
        Dentist[] array = new Dentist[2];
        Address docAddress = new Address("Belarus", "Minsk", "Pushkina", 66);
        Phone docPhone = new Phone("+375", "17", "33-44-55");
        array[0] = new Dentist(LocalDate.of(1965, 2, 13), "Denis",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Dentist", 500);
        array[1] = new Dentist(LocalDate.of(1965, 2, 13), "Diana",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Dentist", 500);

        return array;
    }

    public Emergency[] createEmergency() {
        Emergency[] array = new Emergency[3];
        Address docAddress = new Address("Belarus", "Minsk", "Pushkina", 66);
        Phone docPhone = new Phone("+375", "17", "33-44-55");
        array[0] = new Emergency(LocalDate.of(1965, 2, 13), "Elena",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Emergency", 500);
        array[1] = new Emergency(LocalDate.of(1965, 2, 13), "Egor",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Emergency", 500);
        array[2] = new Emergency(LocalDate.of(1965, 2, 13), "Evgeny",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Emergency", 2000);
        return array;
    }

    public Infectiologist[] createInfectioligist() {
        Infectiologist[] array = new Infectiologist[1];
        Address docAddress = new Address("Belarus", "Minsk", "Pushkina", 66);
        Phone docPhone = new Phone("+375", "17", "33-44-55");
        array[0] = new Infectiologist(LocalDate.of(1965, 2, 13), "Irina",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Infectiologist", 500);
        return array;
    }

    public Surgeon[] createSurgeon() {
        Surgeon[] array = new Surgeon[2];
        Address docAddress = new Address("Belarus", "Minsk", "Pushkina", 66);
        Phone docPhone = new Phone("+375", "17", "33-44-55");
        array[0] = new Surgeon(LocalDate.of(1965, 2, 13), "Sergey",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Surgeon", 500);
        array[1] = new Surgeon(LocalDate.of(1965, 2, 13), "Sveta",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Surgeon", 500);
        return array;
    }
}