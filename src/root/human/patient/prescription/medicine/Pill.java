package root.human.patient.prescription.medicine;

public class Pill implements Info{
    public Pill(String name) {
        this.name = name;
    }

    public String name;

    public void say(){
        System.out.println("say hello");}

    @Override
    public void showInfo(){
        System.out.println("pill implement show info   " + name);
    }



}
