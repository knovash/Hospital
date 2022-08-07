package root.hospital.department;

public class DepartmentCardiology extends Department {

    public DepartmentCardiology(String name) {
        super(name);
    }

    public void makeReport() {
        System.out.println("Department Cardiology report:");
    }
}