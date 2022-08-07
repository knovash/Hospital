import java.time.LocalDate;

public class HospitalUtils {

    public static void match(Doctor[] arrayDoctors, Patient[] arrayPatients) {
        for (int i = 0; i < arrayPatients.length; i++) {
            System.out.println("patient " + arrayPatients[i].getName() + " $" + arrayPatients[i].getCredit().getBalance() + " search for doctor " + arrayPatients[i].getToDoctor());
            Integer index = null;
            for (int j = 0; j < arrayDoctors.length; j++) {
                if (arrayPatients[i].getToDoctor() == arrayDoctors[j].getSpecialty()) {
                    System.out.println(arrayDoctors[j].getSpecialty() + " " + arrayDoctors[j].getName() + " Free from: " + arrayDoctors[j].getDateFreeFrom());
                    System.out.println("doctor Price: $" + arrayDoctors[j].getPrice() + " patient Credit: $" + arrayPatients[i].getCredit().getBalance());

                    if (arrayDoctors[j].getPrice() <= arrayPatients[i].getCredit().getBalance()) {
                        System.out.println("Price matched!");
                        if (index == null) {
                            index = j;
                        } else {
                            if (arrayDoctors[j].getDateFreeFrom().isBefore(arrayDoctors[index].getDateFreeFrom())) {
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
                //create Appointment
                //public Appointment(LocalDate date, Doctor doctor, Patient patient, int price, String place)
                Appointment appointment = new Appointment(arrayDoctors[index].getDateFreeFrom(), arrayDoctors[index], arrayPatients[i], arrayDoctors[index].getPrice(), "cabinet 2");
                arrayPatients[i].setAppointment(appointment);

                LocalDate doctorDate = arrayDoctors[index].getDateFreeFrom();
                LocalDate doctorDateNew = doctorDate.plusDays(1);
                arrayDoctors[index].setDateFreeFrom(doctorDateNew);
                arrayDoctors[index].appointmentCounter++;
                Credit tmpCredit = arrayPatients[i].getCredit();
                tmpCredit.setBalance(tmpCredit.getBalance()-arrayDoctors[index].getPrice());
                arrayPatients[i].setCredit(tmpCredit);
                System.out.println();
                System.out.println("Appointment accepted: " + arrayPatients[i].getName() + " to " + arrayPatients[i].getToDoctor() + " " + arrayDoctors[index].getName() +
                        " Date appointed: " + arrayPatients[i].getAppointment().getDate() + " docAppCount: " + arrayDoctors[index].appointmentCounter +
                        " remained " + arrayPatients[i].getCredit().getBalance());
                System.out.println();
            } else {
                System.out.println("Nothing matched");
                System.out.println();
            }
        }
    }

    public static void matchResult(Patient[] arrayPatients)
    {
        for (Patient item : arrayPatients
        ) {
            System.out.println(item.getAppointment().getDate() + " " +
                    item.getAppointment().getPatient().getName() + " to " +
                    item.getAppointment().getDoctor().getSpecialty() + " " +
                    item.getAppointment().getDoctor().getName() + " price " +
                    item.getAppointment().getPrice());
        }

    }

    public static void print(Doctor[] array) {
        for (Doctor item : array) {
            System.out.println(item.getName() + " " + item.getSpecialty() + " " + item.getPrice() + " " + item.getDateFreeFrom());
        }
    }

    public static void print(Patient[] array) {
        for (Patient item : array) {
            System.out.println(item.getName() + " to " + item.getToDoctor() + " " + item.getDateDesired() + " $" + item.getCredit().getBalance());
        }
    }


}
