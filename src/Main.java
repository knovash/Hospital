import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Create hospital
        Hospital hospital = ToolHospital.create();
        
        // Print hospital
        System.out.println("Create hospital:");
        System.out.println(hospital.getName() + " founded at " + hospital.getDateOfFoundation());
        System.out.println(hospital.getAddress().getCountry() + " " + hospital.getAddress().getCity());
        System.out.println(hospital.getPhone()[0].getCountryCode() + hospital.getPhone()[0].getCityCode() + hospital.getPhone()[0].getLocalNumber());
        System.out.println(hospital.getPhone()[1].getCountryCode() + hospital.getPhone()[1].getCityCode() + hospital.getPhone()[1].getLocalNumber());
        System.out.println(hospital.getPhone()[2].getCountryCode() + hospital.getPhone()[2].getCityCode() + hospital.getPhone()[2].getLocalNumber());


        // create empty departments (without doctors)
        Department depSurgery = new Department("Surgery");
        Department depDental = new Department("Dental");
        Department depCardio = new Department("Cardiology");
        Department depEmergency = new Department("Emergency");
        Department[] arrDepartments = {depSurgery, depDental, depCardio, depEmergency};

        hospital.setDepartment(arrDepartments);

        System.out.println();
        System.out.println("Create departments:");
        System.out.println("get names from dep[] from hospital");
        for (Department item : hospital.getDepartment()
        ) {
            System.out.println(item.getName());
        }

        // Create doctors array
        Doctor[] arrDoctors = new ToolDoctor().create();
        System.out.println();
        System.out.println("Doctors:");
        HospitalUtils.print(arrDoctors);    // owerload
        depSurgery.setDoctor(arrDoctors);
        depDental.setDoctor(arrDoctors);
        depCardio.setDoctor(arrDoctors);
        depEmergency.setDoctor(arrDoctors);

        System.out.println();
        System.out.println("Patients:");
        Patient[] arrPatients = new ToolPatient().create();
        HospitalUtils.print(arrPatients);   // owerload
        hospital.setPatient(arrPatients);

        // set all doctors free from now
        for (Doctor item : arrDoctors
        ) {
            item.setDateFreeFrom(LocalDate.now());
        }

        System.out.println();
        System.out.println("matching patients and doctors...");
        System.out.println();
        HospitalUtils.match(arrDoctors, arrPatients);

        System.out.println();
        System.out.println("match result:");
        HospitalUtils.matchResult(arrPatients);



    }
}
