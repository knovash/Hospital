package root.medicine;

public class Injection {

    public int id;

    public Injection(int id) {
        this.id = id;
    }

    public void sleep() {
        System.out.println("im sleep");
    }

    public void takeInjection() {
        System.out.println("injection implement show info    " + id);
    }

}
