package root.hospital.department;

public class DepartmentInfectious extends Department {

    public DepartmentInfectious(String name) {
        super(name);
    }

    public void makeReport() {
        System.out.println("Department Infectious report:");
    }
}