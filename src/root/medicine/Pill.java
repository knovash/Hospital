package root.medicine;

public class Pill {

    public Pill(String name) {
        this.name = name;
    }

    public String name;

    public void say() {
        System.out.println("say hello");
    }

    public void takePill() {
        System.out.println("pill implement show info   " + name);
    }


}
