import java.time.LocalDate;

public class CreatePatients {

    public Patient[] makeArray() {
        Patient[] array = new Patient[11];
        Reception robot = new Reception();

        robot.registerPatient(array, 0, "Oleg", LocalDate.of(1989, 4, 3), 99, "Emergency", "leg fracture", LocalDate.now());
        robot.registerPatient(array, 1, "Ivan", LocalDate.of(1983, 2, 13), 2000, "Dentist", "toothache", LocalDate.now());
        robot.registerPatient(array, 2, "Maria", LocalDate.of(1996, 10, 22), 350, "Neurologist", "headache", LocalDate.of(2022, 7, 28));
        robot.registerPatient(array, 3, "Anna", LocalDate.of(1970, 6, 8), 10, "Cardiologist", "increased blood pressure", LocalDate.of(2022, 8, 3));
        robot.registerPatient(array, 4, "Boris", LocalDate.of(1989, 4, 3), 500, "Emergency", "gunshot", LocalDate.now().plusDays(3));
        robot.registerPatient(array, 5, "Ivan", LocalDate.of(1983, 2, 13), 400, "Dentist", "toothache", LocalDate.now().plusDays(0));
        robot.registerPatient(array, 6, "Alex", LocalDate.of(1983, 12, 11), 2000, "Dentist", "toothache", LocalDate.now().plusDays(0));
        robot.registerPatient(array, 7, "Jhon", LocalDate.of(1984, 2, 2), 350, "Dentist", "toothache", LocalDate.now().plusDays(3));
        robot.registerPatient(array, 8, "Alesja", LocalDate.of(1999, 5, 13), 500, "Dentist", "toothache", LocalDate.now().plusDays(0));
        robot.registerPatient(array, 9, "Irina", LocalDate.of(1978, 2, 23), 700, "Dentist", "toothache", LocalDate.now().plusDays(2));
        robot.registerPatient(array, 10, "Sveta", LocalDate.of(1983, 7, 1), 100, "Dentist", "toothache", LocalDate.now().plusDays(0));
        return array;
    }
}
