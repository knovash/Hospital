import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Create array of Doctors
        Doctors[] arrayDoctors = new Doctors[9];
        arrayDoctors[0] = new Doctors("Petr", "Dentist", 500);
        arrayDoctors[1] = new Doctors("Igor", "Dentist", 300);
        arrayDoctors[2] = new Doctors("Ivan", "Surgeon", 700);
        arrayDoctors[3] = new Doctors("Olga", "Surgeon", 1000);
        arrayDoctors[4] = new Doctors("Natalia", "Cardiologist", 300);
        arrayDoctors[5] = new Doctors("Elena", "Neurologist", 200);
        arrayDoctors[6] = new Doctors("Alex", "Emergency", 50);
        arrayDoctors[7] = new Doctors("Zina", "Emergency", 50);
        arrayDoctors[8] = new Doctors("Boris", "Emergency", 50);

        arrayDoctors[0].setDataFreeFrom(LocalDate.now());
        arrayDoctors[1].setDataFreeFrom(LocalDate.now());
        arrayDoctors[2].setDataFreeFrom(LocalDate.now());
        arrayDoctors[3].setDataFreeFrom(LocalDate.now());
        arrayDoctors[4].setDataFreeFrom(LocalDate.now());
        arrayDoctors[5].setDataFreeFrom(LocalDate.now());
        arrayDoctors[6].setDataFreeFrom(LocalDate.now());
        arrayDoctors[7].setDataFreeFrom(LocalDate.now());
        arrayDoctors[8].setDataFreeFrom(LocalDate.now());

        // Create array of Patients
        Patients[] arrayPatients = new Patients[11];
        arrayPatients[0] = new Patients("Oleg", LocalDate.of(1989, 4, 3), 500, "Emergency", "leg fracture", LocalDate.now());
        arrayPatients[1] = new Patients("Ivan", LocalDate.of(1983, 2, 13), 2000, "Dentist", "toothache", LocalDate.now());
        arrayPatients[2] = new Patients("Maria", LocalDate.of(1996, 10, 22), 350, "Neurologist", "headache", LocalDate.of(2022, 7, 28));
        arrayPatients[3] = new Patients("Anna", LocalDate.of(1970, 6, 8), 10, "Cardiologist", "increased blood pressure", LocalDate.of(2022, 8, 3));
        arrayPatients[4] = new Patients("Boris", LocalDate.of(1989, 4, 3), 500, "Emergency", "gunshot", LocalDate.now().plusDays(3));
        arrayPatients[5] = new Patients("Ivan", LocalDate.of(1983, 2, 13), 2000, "Dentist", "toothache", LocalDate.now().plusDays(0));
        arrayPatients[6] = new Patients("Alex", LocalDate.of(1983, 12, 11), 2000, "Dentist", "toothache", LocalDate.now().plusDays(0));
        arrayPatients[7] = new Patients("Jhon", LocalDate.of(1984, 2, 2), 350, "Dentist", "toothache", LocalDate.now().plusDays(3));
        arrayPatients[8] = new Patients("Alesja", LocalDate.of(1999, 5, 13), 500, "Dentist", "toothache", LocalDate.now().plusDays(0));
        arrayPatients[9] = new Patients("Irina", LocalDate.of(1978, 2, 23), 700, "Dentist", "toothache", LocalDate.now().plusDays(2));
        arrayPatients[10] = new Patients("Sveta", LocalDate.of(1983, 7, 1), 100, "Dentist", "toothache", LocalDate.now().plusDays(0));

//        Create array of Appointments
//        Appointments[] arrayAppointments = new Appointments[3];
//        arrayAppointments[0] = new Appointments(arrayDoctors[1].getName(), "Anna", LocalDate.of(2022, 7, 28));
//        arrayAppointments[1] = new Appointments(arrayDoctors[2].getName(), "Ivan", LocalDate.now().plusDays(3));
//        arrayAppointments[2] = new Appointments(arrayDoctors[3].getName(), "Oleg", LocalDate.now());

        // print
        printArray(arrayDoctors);
        printArray(arrayPatients);


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


        // print
        printArray(arrayDoctors);
        printArray(arrayPatients);


    }

    // Methods

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
