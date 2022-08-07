package root.human.patient.prescription.medicine;

public class Injection extends Medicine{

    public Injection(String name, String description, int price, int quantity) {
        super(name, description, price, quantity);
    }

    public void takeInjection() {
        System.out.println("Doctor make diagnosis.");
    }
}
