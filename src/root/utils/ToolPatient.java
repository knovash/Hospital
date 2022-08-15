package root.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.exception.InvalidNameException;
import root.human.property.Address;
import root.human.property.Credit;
import root.human.patient.Patient;
import root.human.property.Phone;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ToolPatient {

    private static final Logger LOGGER = LogManager.getLogger(ToolPatient.class);

    public Patient[] create() throws InvalidNameException {
        Patient[] array = new Patient[9];
        array[0] = new Patient(LocalDate.of(1988, 2, 13), "Igor",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", new BigDecimal("3000")), "Dentist", LocalDate.now());
        array[1] = new Patient(LocalDate.of(1999, 2, 13), "A_lex",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", new BigDecimal("500")), "Dentist", LocalDate.now().minusDays(0));
        array[2] = new Patient(LocalDate.of(1999, 2, 13), "Vera",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", new BigDecimal("3000")), "Emergency", LocalDate.now());
        array[3] = new Patient(LocalDate.of(1999, 2, 13), "Konstantin",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", new BigDecimal("300")), "Dentist", LocalDate.now());
        array[4] = new Patient(LocalDate.of(1965, 2, 13), "Victor",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", new BigDecimal("800")), "Surgeon", LocalDate.now());
        array[5] = new Patient(LocalDate.of(1965, 2, 13), "Vladimir",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", new BigDecimal("700")), "Emergency", LocalDate.now());
        array[6] = new Patient(LocalDate.of(1965, 2, 13), "Boris",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", new BigDecimal("600")), "Dentist", LocalDate.now());
        array[7] = new Patient(LocalDate.of(1965, 2, 13), "Anna",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", new BigDecimal("1000")), "Surgeon", LocalDate.now());
        array[8] = new Patient(LocalDate.of(1965, 2, 13), "Maria",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", new BigDecimal("1500")), "Dentist", LocalDate.now());
        return array;
    }
}