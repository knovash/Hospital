import java.time.LocalDate;

public class Patient {

        //Fields
        private LocalDate dateOB;
        private int age;
        private String name;
        private FullName fullName;
        private Address address;
        private Phone phone;
        private LocalDate dateDesired;
        //private LocalDate dateAppointed;
        private String toDoctor;
        private Credit credit;
        private Appointment appointment;
        private Prescription prescription;
        static int totalAppointments;


        //Constructors
        public Patient(LocalDate dateOB, String name, Address address, Phone phone) {
            this.dateOB = dateOB;
            this.name = name;
            this.address = address;
            this.phone = phone;

        }

    public Patient(LocalDate dateOB, String name, Address address, Phone phone, Credit credit, String toDoctor, LocalDate dateDesired) {
        this.dateOB = dateOB;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.credit = credit;
        this.toDoctor = toDoctor;
        this.dateDesired = dateDesired;
        this.age = LocalDate.now().getYear() - dateOB.getYear();
    }

        // Methods

        // Getters and Setters


    public LocalDate getDateOB() {
        return dateOB;
    }

    public void setDateOB(LocalDate dateOB) {
        this.dateOB = dateOB;
        this.age = LocalDate.now().getYear() - dateOB.getYear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public LocalDate getDateDesired() {
        return dateDesired;
    }

    public void setDateDesired(LocalDate dateDesired) {
        this.dateDesired = dateDesired;
    }

    public String getToDoctor() {
        return toDoctor;
    }

    public void setToDoctor(String toDoctor) {
        this.toDoctor = toDoctor;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
