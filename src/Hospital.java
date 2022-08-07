import java.time.LocalDate;

public class Hospital {

    //Fields
    private String name;
    private String adresds;
    private String phone;
    private int credit;
    private Doctors doctor;
    private Patients patient;
    private Medicines medicine;


    //Constructors
    public Hospital(String name, String adresds, String phone, int credit) {
        this.name = name;
        this.adresds = adresds;
        this.phone = phone;
        this.credit = credit;
    }

    // Methods
    public Doctors[] hireDoctor(Doctors[] array, int number, String name, String specialty, int price) {
        array[number] = new Doctors(name, specialty, price);
        this.credit = this.credit - price;
        System.out.println("Hired new doctor: " + name + " " + specialty);
        return array;
    }

    public Doctors[] dismissDoctor(Doctors[] array, int number) {
        System.out.println("Dissmissed doctor: " + array[number].getName() + " " + array[number].getSpecialty());
        array[number] = new Doctors("", "", 0);
        Doctors.count--;
        return array;
    }

    public Patients[] registerPatient(Patients[] array, int number,
     String name, LocalDate dateOB, int credit, String doctor, String problem, LocalDate dateDesired) {
        array[number] = new Patients(name, dateOB, credit, doctor, problem, dateDesired);
        System.out.println("Registred new patient: " + name + " wants to " + doctor);
        Doctors.count--;
        return array;
    }

    public void storeMedicine(Medicines medicine, int quantity){
        //System.out.println("Hospital credit: " + this.credit);
        medicine.setquantity(medicine.getquantity() + quantity);
        this.credit = this.credit - quantity * medicine.getPrice();
        System.out.println("Hospital stored " + quantity + " of " + medicine.getName() );
        System.out.println("Hospital credit: " + this.credit);
    }

    // Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresds() {
        return adresds;
    }

    public void setAdresds(String adresds) {
        this.adresds = adresds;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Doctors getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public Medicines getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicines medicine) {
        this.medicine = medicine;
    }
}