package root.human.patient;

import root.human.doctor.Doctor;

import java.util.List;

public interface IRegistrate {

    void getInHospital();

    void getOutHospital();

    void makeAppointment(List<Doctor> doctors);

}
