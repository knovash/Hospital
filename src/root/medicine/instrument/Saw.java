package root.medicine.instrument;

public class Saw extends Instrument{

    private String name;
    private int quantity;

    public Saw(String name, int quantity) {
        super(name, quantity);
    }


    public void useScalpel() {
        System.out.println("use instrument scalpel");
    }

}
