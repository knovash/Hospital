package root.hospital.department;

public class DepartmentDental extends Department {

    public DepartmentDental(String name) {
        super(name);
    }

    public void makeReport() {
        System.out.println("Department Dental report:");
    }
}