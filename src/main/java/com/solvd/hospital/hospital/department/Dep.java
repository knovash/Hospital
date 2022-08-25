package com.solvd.hospital.hospital.department;

public enum Dep {
    CARD("dep. Cardiology"), DENT("dep. Dental"), EMER("dep. Emergency"), INFECT("dep. Infectiology"), SURG("dep. Surgery");

    private final String displayName;

    Dep(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}