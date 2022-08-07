import java.time.LocalDate;

// overload method printArray
public class Main {
    public static void main(String[] args) {

        // Create hospital
        Hospital hospital = new Hospital("Arkham", "Gotham City", "03", 1000000);
        System.out.println("Creating hospital...");
        hospital.print();

        // Hiring staff
        CreateDoctors docBot = new CreateDoctors();
        Doctor[] arrayDoctors = docBot.makeArray(hospital);
        hospital.print();

        // Create HR. Dismiss and Hire stuff
        HumanResources hr = new HumanResources();
        printArray(arrayDoctors);
        hr.dismissDoctor(arrayDoctors, 3);
        hr.hireDoctor(hospital, arrayDoctors, 3, "Alex", "Surgeon", 700);
        printArray(arrayDoctors);

        // Patient registration
        System.out.println("Registating patients...");
        CreatePatients patBot = new CreatePatients();
        Patient[] arrayPatients = patBot.makeArray();

        // match Patient and Doctor
        System.out.println("Matching patients and doctors...");
        Reception.searchDoctor(hospital, arrayDoctors, arrayPatients);
        printArray(arrayPatients);
        printArray(arrayDoctors);

        // Medicines
        CreateMedicines medBot = new CreateMedicines();
        Medicine[] arrayMedicines = medBot.makeArray();
        printArray(arrayMedicines);

        // arrayPatients[2].takeMedicine(aspirin);
        // System.out.println(arrayPatients[2].getName() +"-"+ arrayPatients[2].getMedicine()  +"-"+ arrayPatients[2].getCountMedicineTake());

    }

    // Methods

    public static void printArray(Doctor[] array) {
        System.out.println();
        System.out.println("Name - Specialty - Price - DateFreeFrom - CounterAppointments");
        for (Doctor item : array) {
            System.out.println(item.print());
        }
        System.out.println();
    }

    public static void printArray(Patient[] array) {
        System.out.println();
        System.out.println("Number of patients: " + Patient.count);
        System.out.println("Name - Age - Credit - Doctor - Problem - DateDesired - DateAppointed - PriceAppointed");
        for (Patient item : array) {
            System.out.println(item.print());
        }
        System.out.println();
    }

    public static void printArray(Medicine[] array) {
        System.out.println();
        //System.out.println("Number of patients: " + Patient.count);
        System.out.println("Medicine:");
        for (Medicine item : array) {
            System.out.println(item.print());
        }
        System.out.println();
    }
}
