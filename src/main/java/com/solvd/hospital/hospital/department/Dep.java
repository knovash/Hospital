package com.solvd.hospital.hospital.department;


public enum Dep {
    CARD("dep. Cardiologist"), DENT("dep. Dentist"), EMER("dep. Emergency"), INFECT("dep. Infectiologist"), SURG("dep. Surgeon");
    private final String displayName;

    Dep(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}