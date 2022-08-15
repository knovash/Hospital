package root;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import root.exception.*;
import root.hospital.Hospital;
import root.hospital.department.*;
import root.human.property.Phone;
import root.human.doctor.*;
import root.human.patient.Patient;
import root.utils.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        LOGGER.debug("log debug");
        LOGGER.info("log info");
        LOGGER.error("log error");
        LOGGER.warn("log warn");
        // create hospital
        Hospital hospital = ToolHospital.create();
        LOGGER.info("Create hospital:");
        LOGGER.info(hospital);
        LOGGER.info(hospital.getAddress().toString());
        for (Phone item : hospital.getPhones()) {
            LOGGER.info(item.toString());
        }
        // create doctors
        Cardiologist[] cardiologists;
        Dentist[] dentists;
        Emergency[] emergencys;
        Infectiologist[] infectiologysts;
        Surgeon[] surgeons;
        try {
            cardiologists = new ToolDoctor().createCardiologist();
            dentists = new ToolDoctor().createDentist();
            emergencys = new ToolDoctor().createEmergency();
            infectiologysts = new ToolDoctor().createInfectioligist();
            surgeons = new ToolDoctor().createSurgeon();
        } catch (InvalidNameException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        // create departments
        Department[] departments = new ToolDepartment().create();
        // set doctors to departments
        departments[0].setDoctor(cardiologists);
        departments[1].setDoctor(dentists);
        departments[2].setDoctor(emergencys);
        departments[3].setDoctor(infectiologysts);
        departments[4].setDoctor(surgeons);
        // set departments to hospital
        hospital.setDepartments(departments);
        // set doctors date free from now
        LOGGER.info("");
        LOGGER.info("doctors:");
        for (Department department : hospital.getDepartments()) {
            LOGGER.info(department.toString());
            for (Doctor doctor : department.getDoctor()) {
                doctor.setFreeFromDate(LocalDate.now());
                LOGGER.info("  " + doctor);
            }

        }

        // create patients
        LOGGER.debug("try create patients");
        Patient[] patients = new Patient[0];
        try {
            patients = new ToolPatient().create();
        } catch (InvalidNameException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } finally {
            LOGGER.debug("try create Patients end");
        }
        // set patients to hospital
        try {
            hospital.setPatients(patients);
        } catch (ArrayOneElementException e) {
            LOGGER.warn(e.getMessage(), e);
        } finally {
            LOGGER.debug("set patients to hospital. end.");
        }

        LOGGER.info("patients:");
        for (Patient patient : hospital.getPatients()) {
            LOGGER.info(patient.toString());
        }

        // match patients and doctors
        LOGGER.info("");
        LOGGER.info("matching patients and doctors...");
        LOGGER.info("");
        for (Department department : hospital.getDepartments()) {
            LOGGER.debug(department.toString());
            HospitalUtils.match(department.getDoctor(), hospital.getPatients());
        }

        LOGGER.info("");
        LOGGER.info("match result:");
        HospitalUtils.matchResult(hospital.getPatients());

        // test interface
        LOGGER.debug("interface");
        Patient patient = hospital.getPatients()[0];
        Doctor[] docs = hospital.getDepartments()[1].getDoctor();
        patient.makeAppointment(docs);  // (Doctors[], Patient[0])

        // test try with resources

        FileOutputStream output = null;
        try {
            output = new FileOutputStream("list.txt");
            output.write(2);
        } catch (ArithmeticException e) {
            LOGGER.error("ArithmeticException");
        } catch (IOException e) {
            LOGGER.error("IOException");
        } finally {
            if (output != null) {
                output.close();
            }
            LOGGER.debug("file closed");
        }

        // test try-with-res method already with close()
        try (FileOutputStream outputNew = new FileOutputStream("list_new.txt")) {
            outputNew.write(3);
        }
        LOGGER.debug("file closed");

        // test try-with-res my method Text with AutoCloseable
        try (Text text = new Text("list_new.txt")) {
            text.write(7 / 0 + "xxx");
        }

    }

    public static class Text implements AutoCloseable {
        private String path;

        public Text(String path) {
            this.path = path;
        }

        public void write(String value) throws IOException {
            LOGGER.debug("write to: " + this.path + " value: " + value);
            Files.writeString(Path.of(path), value);
        }

        @Override
        public void close() {
            LOGGER.info("file auto closed");
        }
    }
}