public class CreateDoctors {

    public Doctor[] makeArray(Hospital hospital) {
        Doctor[] array = new Doctor[8];
        HumanResources robot = new HumanResources();

        robot.hireDoctor(hospital, array, 0, "Jhon", "Dentist", 500);
        robot.hireDoctor(hospital, array, 1, "Igor", "Dentist", 200);
        robot.hireDoctor(hospital, array, 2, "Vladimir", "Surgeon", 1000);
        robot.hireDoctor(hospital, array, 3, "Olga", "Surgeon", 600);
        robot.hireDoctor(hospital, array, 4, "Natalia", "Cardiologist", 300);
        robot.hireDoctor(hospital, array, 5, "Elena", "Neurologist", 200);
        robot.hireDoctor(hospital, array, 6, "Boris", "Emergency", 100);
        robot.hireDoctor(hospital, array, 7, "Zina", "Emergency", 50);

        return array;
    }
}
