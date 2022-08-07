public class Department {

    //fields
    private String name;
    private Doctor[] doctor;
    static int totalDoctorsInHospital;

    //constructors
    public Department(String name) {
        this.name = name;
    }

    //methods

    //setters and getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doctor[] getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor[] doctor) {
        this.doctor = doctor;
    }
}