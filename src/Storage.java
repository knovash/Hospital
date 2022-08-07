import java.time.LocalDate;

public class Storage {

    // Methods
    public Medicine[] storeMedicine(Medicine[] array, int number,
                                    String name, int price, int quantity) {
        array[number] = new Medicine(name, price, quantity );
        System.out.println("Stored medicine : " + name + " quantity: " + quantity);
        return array;
    }


    // Getters and Setters


}