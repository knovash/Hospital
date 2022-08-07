package root.human.patient.prescription.procedure;

public class Procedure {
    //Fields
    private String name;
    private String description;
    private int price;
    private int duration;

    public Procedure(String name, String description, int price, int quantity) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}