package root.medicine.instrument;

public class Scalpel extends Instrument{

    private String name;
    private int quantity;

    public Scalpel(String name, int quantity) {
        super(name, quantity);
    }

    public void useScalpel() {
        LOGGER.info("use instrument scalpel");
    }

}
