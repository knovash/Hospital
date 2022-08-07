package root.hospital.department;

public class DepartmentEmergency extends Department {

    public DepartmentEmergency(String name) {
        super(name);
    }

    public void makeReport() {
        System.out.println("Department Emergency report:");
    }
}