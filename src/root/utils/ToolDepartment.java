package root.utils;

import root.exception.InvalidNameException;
import root.hospital.department.*;

import java.util.HashMap;
import java.util.Map;

public class ToolDepartment {

    public Map<String, Department> createDepartment() throws InvalidNameException {
        Map<String, Department> departments = new HashMap<>();
        departments.put("crd", new DepartmentCardiology("Cardiology"));
        departments.put("dnt", new DepartmentDental("Dental"));
        departments.put("emr", new DepartmentEmergency("Emergency"));
        departments.put("inf", new DepartmentInfectious("Infectious"));
        departments.put("sur", new DepartmentSurgery("Surgery"));
        return departments;
    }
}