import java.time.LocalDate;

public class Patients {

    //Fields
    private String name;
    private LocalDate dateOB;
    private int age;
    private int credit;
    private String problem;
    private LocalDate dateDesired;
    private LocalDate dateAppointed;
    private int priceAppointed;
    private String doctor;
    //private String diagnosis;
    //private String prescription;
    public static int count = 0;

    //Constructors
    public Patients(String name, LocalDate dateOB, int credit, String doctor, String problem, LocalDate dateDesired) {
        this.name = name;
        this.dateOB = dateOB;
        this.credit = credit;
        this.doctor = doctor;
        this.problem = problem;
        this.dateDesired = dateDesired;
        this.age = LocalDate.now().getYear() - dateOB.getYear();
        count++;
    }

    // Methods

    public String print() {
        String text = (
                        this.name + " " +
                        this.age + " $" +
                        this.credit + " " +
                        this.doctor + " " +
                        this.problem + " " +
                        this.dateDesired + " " +
                        this.dateAppointed + " " +
                        this.priceAppointed);
        return text;
    }



    // Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOB() {
        return dateOB;
    }

    public void setDateOB(LocalDate dateOB) {
        this.dateOB = dateOB;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public LocalDate getDateDesired() {
        return dateDesired;
    }

    public void setDateDesired(LocalDate dateDesired) {
        this.dateDesired = dateDesired;
    }

    public LocalDate getDateAppointed() {
        return dateAppointed;
    }

    public void setDateAppointed(LocalDate dateAppointed) {
        this.dateAppointed = dateAppointed;
    }

    public int getPriceAppointed() {
        return priceAppointed;
    }

    public void setPriceAppointed(int priceAppointed) {
        this.priceAppointed = priceAppointed;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
