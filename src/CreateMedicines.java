import java.time.LocalDate;

public class CreateMedicines {

    public Medicine[] makeArray() {
        Medicine[] array = new Medicine[7];
        Storage robot = new Storage();

        robot.storeMedicine(array, 0, "Aspirin", 10, 50);
        robot.storeMedicine(array, 1, "Insulin", 5, 100);
        robot.storeMedicine(array, 2, "Validol", 15, 200);
        robot.storeMedicine(array, 3, "Morphine", 50, 60);
        robot.storeMedicine(array, 4, "Calcium", 20, 250);
        robot.storeMedicine(array, 5, "Citramon", 40, 30);
        robot.storeMedicine(array, 6, "Suprastin", 35, 45);

        return array;
    }
}
