import java.time.LocalDate;

public class ToolPatient {

    public Patient[] create() {
        Patient[] array = new Patient[9];
        //public Patient(LocalDate dateOB, String name, Address address, Phone phone)
        //public Patient(LocalDate dateOB, String name, Address address, Phone phone, Credit credit, String toDoctor, LocalDate dateDesired)

        array[0] = new Patient(LocalDate.of(1965, 2, 13), "Igor",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", 5000), "Dentist", LocalDate.now());

        array[1] = new Patient(LocalDate.of(1965, 2, 13), "Oleg",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", 600), "Surgeon", LocalDate.now());

        array[2] = new Patient(LocalDate.of(1965, 2, 13), "Vera",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", 1000), "Emergency", LocalDate.now());

        array[3] = new Patient(LocalDate.of(1965, 2, 13), "Konstantin",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", 3000), "Dentist", LocalDate.now());

        array[4] = new Patient(LocalDate.of(1965, 2, 13), "Victor",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", 1000), "Surgeon", LocalDate.now());

        array[5] = new Patient(LocalDate.of(1965, 2, 13), "Vladimir",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", 700), "Emergency", LocalDate.now());

        array[6] = new Patient(LocalDate.of(1965, 2, 13), "Boris",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", 1000), "Dentist", LocalDate.now());

        array[7] = new Patient(LocalDate.of(1965, 2, 13), "Anna",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", 1500), "Surgeon", LocalDate.now());

        array[8] = new Patient(LocalDate.of(1965, 2, 13), "Maria",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"),
                new Credit("Prior", "BYN", 2000), "Dentist", LocalDate.now());
        return array;
    }

}