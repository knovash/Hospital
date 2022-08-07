package root.hospital.department;

public class DepartmentSurgery extends Department {

    public DepartmentSurgery(String name) {
        super(name);
    }

    public void makeReport() {
        System.out.println("DepartmentSurgery report:");
    }

}