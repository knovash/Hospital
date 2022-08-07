package root.utils;

import root.hospital.department.*;

public class ToolDepartment {

    public Department[] create() {
        Department[] array = new Department[5];
        array[0] = new DepartmentDental("Cardiology");
        array[1] = new DepartmentDental("Dental");
        array[2] = new DepartmentEmergency("Emergency");
        array[3] = new DepartmentInfectious("Infectious");
        array[4] = new DepartmentSurgery("Surgery");
        return array;
    }
}