package root.human.patient.prescription.medicine;

public class Pill extends Medicine {
    public Pill(String name, String description, int price, int quantity) {
        super(name, description, price, quantity);
    }

    public void takePill() {
        System.out.println("take pill");
    }
}
