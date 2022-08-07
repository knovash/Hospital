package root.instrument;

public class Instrument {

    private String name;
    private int quantity;

    public Instrument(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void use() {
        System.out.println("use instrument");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
