package root.human.patient.prescription.medicine;

public class Injection implements Info{

    public int id;

    public Injection(int id){
        this.id = id;
    }
    public void sleep(){
        System.out.println("im sleep");
    }

    @Override
    public void showInfo(){
        System.out.println("injection implement show info    " + id);
    }

}
