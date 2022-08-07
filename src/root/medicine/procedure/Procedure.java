package root.medicine.procedure;

import java.math.BigDecimal;

public class Procedure {

    private String name;
    private String description;
    private BigDecimal price;
    private int duration;

    public Procedure(String name, String description, BigDecimal price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
    }

    public void takeProcedure() {
        System.out.println("take procedure");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}