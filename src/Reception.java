import java.time.LocalDate;

public class Reception {
    //Fields

    //Constructors
    public Reception() {
    }

    // Methods

    public Patient[] registerPatient(Patient[] array, int number,
                                     String name, LocalDate dateOB, int credit, String doctor, String problem, LocalDate dateDesired) {
        array[number] = new Patient(name, dateOB, credit, doctor, problem, dateDesired);

        System.out.println("Registred new patient: " + name + " wants to " + doctor);

        return array;
    }

    public static void searchDoctor(Hospital hospital, Doctor[] arrayDoctors, Patient[] arrayPatients) {
        System.out.println("Hospital credit: " + hospital.credit);
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
                hospital.credit = hospital.credit + arrayDoctors[index].getPrice();

                System.out.println();
                System.out.println("Appointment accepted: " + arrayPatients[i].getName() + " to " + arrayPatients[i].getDoctor() + " " + arrayDoctors[index].getName() +
                " Date appointed: " + arrayPatients[i].getDateAppointed());
                System.out.println("Doctor " + arrayDoctors[index].getName() + " counter: " + arrayDoctors[index].getCountAppointments());
                System.out.println();
            } else {
                System.out.println("Nothing matched");
                System.out.println();
            }
        }
        System.out.println("Hospital credit: " + hospital.credit);
    }
}

// Getters and Setters


