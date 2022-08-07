import java.time.LocalDate;

public class ToolDoctor {

    public Doctor[] create() {
        Doctor[] array = new Doctor[8];

        Address docAddress = new Address("Belarus", "Minsk", "Pushkina", 66);
        Phone docPhone = new Phone("+375", "17", "33-44-55");
        array[0] = new Doctor(LocalDate.of(1970, 8, 22), "Jhon", docAddress, docPhone, "Surgeon", 700);

        array[1] = new Doctor(LocalDate.of(1965, 2, 13), "Igor",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Surgeon", 500);

        array[2] = new Doctor(LocalDate.of(1965, 2, 13), "Olga",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Dentist", 2000);

        array[3] = new Doctor(LocalDate.of(1965, 2, 13), "Boris",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Dentist", 1000);

        array[4] = new Doctor(LocalDate.of(1965, 2, 13), "Zina",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Emergency", 300);

        array[5] = new Doctor(LocalDate.of(1965, 2, 13), "Alex",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Emergency", 250);

        array[6] = new Doctor(LocalDate.of(1965, 2, 13), "Boris",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Cardiolog", 500);

        array[7] = new Doctor(LocalDate.of(1965, 2, 13), "Nikola",
                new Address("Belarus", "Minsk", "Berezovaja", 16),
                new Phone("+375", "29", "883300"), "Cardiolog", 300);
        return array;
    }

}