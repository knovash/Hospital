package root.human.patient;

import root.human.doctor.Doctor;

public interface Registration {

    void getInHospital();
    void getOutHospital();
    void makeAppointment(Doctor[] doctors);
}
