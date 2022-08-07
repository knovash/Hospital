import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Create hospital
        Hospital hospital = new Hospital("Arkham", "Gotham City", "03", 1000000);

        // Hiring staff
        Doctors[] arrayDoctors = new Doctors[9];
        hospital.hireDoctor(arrayDoctors, 0, "Jhon", "Dentist", 200);
        hospital.hireDoctor(arrayDoctors, 1, "Petr", "Dentist", 500);
        hospital.hireDoctor(arrayDoctors, 2, "Igor", "Dentist", 300);
        hospital.hireDoctor(arrayDoctors, 3, "Vladimir", "Surgeon", 600);
        hospital.hireDoctor(arrayDoctors, 4, "Olga", "Surgeon", 1000);
        hospital.hireDoctor(arrayDoctors, 5, "Natalia", "Cardiologist", 300);
        hospital.hireDoctor(arrayDoctors, 6, "Elena", "Neurologist", 200);
        hospital.hireDoctor(arrayDoctors, 7, "Boris", "Emergency", 50);
        hospital.hireDoctor(arrayDoctors, 8, "Zina", "Emergency", 50);

        // Dissmis and Hire stuff
        printArray(arrayDoctors);
        hospital.dismissDoctor(arrayDoctors, 3);
        hospital.hireDoctor(arrayDoctors, 3, "Alex", "Surgeon", 700);
        printArray(arrayDoctors);

        // all doctors free from today
        for (Doctors item:arrayDoctors ) {
            item.setDataFreeFrom(LocalDate.now() );
        }

        // Patients registration
        Patients[] arrayPatients = new Patients[11];
        hospital.registerPatient(arrayPatients, 0, "Oleg", LocalDate.of(1989, 4, 3), 500, "Emergency", "leg fracture", LocalDate.now());
        hospital.registerPatient(arrayPatients, 1, "Ivan", LocalDate.of(1983, 2, 13), 2000, "Dentist", "toothache", LocalDate.now());
        hospital.registerPatient(arrayPatients, 2, "Maria", LocalDate.of(1996, 10, 22), 350, "Neurologist", "headache", LocalDate.of(2022, 7, 28));
        hospital.registerPatient(arrayPatients, 3, "Anna", LocalDate.of(1970, 6, 8), 10, "Cardiologist", "increased blood pressure", LocalDate.of(2022, 8, 3));
        hospital.registerPatient(arrayPatients, 4, "Boris", LocalDate.of(1989, 4, 3), 500, "Emergency", "gunshot", LocalDate.now().plusDays(3));
        hospital.registerPatient(arrayPatients, 5, "Ivan", LocalDate.of(1983, 2, 13), 2000, "Dentist", "toothache", LocalDate.now().plusDays(0));
        hospital.registerPatient(arrayPatients, 6, "Alex", LocalDate.of(1983, 12, 11), 2000, "Dentist", "toothache", LocalDate.now().plusDays(0));
        hospital.registerPatient(arrayPatients, 7, "Jhon", LocalDate.of(1984, 2, 2), 350, "Dentist", "toothache", LocalDate.now().plusDays(3));
        hospital.registerPatient(arrayPatients, 8, "Alesja", LocalDate.of(1999, 5, 13), 500, "Dentist", "toothache", LocalDate.now().plusDays(0));
        hospital.registerPatient(arrayPatients, 9, "Irina", LocalDate.of(1978, 2, 23), 700, "Dentist", "toothache", LocalDate.now().plusDays(2));
        hospital.registerPatient(arrayPatients, 10, "Sveta", LocalDate.of(1983, 7, 1), 100, "Dentist", "toothache", LocalDate.now().plusDays(0));






        // print
        printArray(arrayPatients);

        // match Patients and Doctors
        searchDoctor(arrayDoctors, arrayPatients);

        // print
        //printArray(arrayDoctors);
        //printArray(arrayPatients);

        // Create medicines
        Medicines aspirin = new Medicines("Aspirin", 10, 0);
        Medicines insulin = new Medicines("Insulin", 5, 0);
        Medicines validol = new Medicines("Validol", 15, 0);
        Medicines morphine = new Medicines("Morphine", 50, 0);
        Medicines calcium = new Medicines("Calcium", 20, 0);
        Medicines citramon = new Medicines("Citramon", 40, 0);
        Medicines suprastin = new Medicines("Suprastin", 35, 0);

        // Hospital store medicines
        hospital.storeMedicine(aspirin, 500);
        hospital.storeMedicine(insulin, 1000);
        hospital.storeMedicine(validol, 100);
        hospital.storeMedicine(morphine, 50);

        System.out.println(aspirin.getName() + " " + aspirin.getquantity() + " " + aspirin.getPrice());
       // System.out.println(arrayPatients[2].getName() +"-"+ arrayPatients[2].getMedicine() );
       // arrayPatients[2].takeMedicine(aspirin);
       // System.out.println(arrayPatients[2].getName() +"-"+ arrayPatients[2].getMedicine()  +"-"+ arrayPatients[2].getCountMedicineTake());



    }

    // Methods

    public static void searchDoctor(Doctors[] arrayDoctors, Patients[] arrayPatients) {
        for (int i = 0; i < arrayPatients.length; i++) {
            System.out.println("Patient (" + arrayPatients[i].getName() + ") search for Doctor (" + arrayPatients[i].getDoctor() + ")");
            Integer index = null;
            for (int j = 0; j < arrayDoctors.length; j++) {
                if (arrayPatients[i].getDoctor() == arrayDoctors[j].getSpecialty()) {
                    System.out.println(arrayDoctors[j].getSpecialty() + " " + arrayDoctors[j].getName() + " Free from: " + arrayDoctors[j].getDataFreeFrom());
                    System.out.println("doctor Price: $" + arrayDoctors[j].getPrice() + " patient Credit: $" + arrayPatients[i].getCredit());

                    if (arrayDoctors[j].getPrice() <= arrayPatients[i].getCredit()) {
                        System.out.println("Price matched!");
                        if (index == null) {
                            index = j;
                        } else {
                            if (arrayDoctors[j].getDataFreeFrom().isBefore(arrayDoctors[index].getDataFreeFrom())) {
                                index = j;
                                System.out.println("Earlier date was found!");
                            }
                        }
                    } else {
                        System.out.println("Appointment rejected");
                    }
                }
            }

            if (index != null) {
                arrayPatients[i].setDateAppointed(arrayDoctors[index].getDataFreeFrom());
                arrayPatients[i].setPriceAppointed(arrayDoctors[index].getPrice());
                LocalDate doctorDate = arrayDoctors[index].getDataFreeFrom();
                LocalDate doctorDateNew = doctorDate.plusDays(1);
                arrayDoctors[index].setDataFreeFrom(doctorDateNew);
                arrayDoctors[index].addCounter();

                System.out.println();
                System.out.println("Appointment accepted");
                System.out.println("Date desired: " + arrayPatients[i].getDateDesired());
                System.out.println("Date appointed: " + arrayPatients[i].getDateAppointed());
                System.out.println("Doctor: " + arrayDoctors[index].getName() + " Counter: " + arrayDoctors[index].getCountAppointments());
                System.out.println();
            } else {
                System.out.println("Nothing matched");
                System.out.println();
            }
        }
    }

    public static void printArray(Doctors[] array) {
        System.out.println("Number of doctors: " + Doctors.count);
        System.out.println("Name - Specialty - Price - DateFreeFrom - CounterAppointments");
        for (Doctors item : array) {
            System.out.println(item.print());
        }
        System.out.println();
    }

    public static void printArray(Patients[] array) {
        System.out.println("Number of patients: " + Patients.count);
        System.out.println("Name - Age - Credit - Doctor - Problem - DateDesired - DateAppointed - PriceAppointed");
        for (Patients item : array) {
            System.out.println(item.print());
        }
        System.out.println();
    }

}
